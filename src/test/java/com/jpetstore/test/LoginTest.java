package com.jpetstore.test;

import com.jpetstore.steps.JPetStoreSteps;
import com.jpetstore.util.TestListener;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(TestListener.class)
@DisplayName("Login Tests")
public class LoginTest extends JPetStoreSteps {

    @Tag(SMOKE)
    //@RepeatedIfExceptionsTest(repeats = 1)
    @Test
    @DisplayName("The valid credential should be provided to log in")
    @Description("Logging into the app via sign on page")
    void doLogin() {
        navigateToApp();
        navigateToSignInPage();
        doLogin("test", "test321");
        assertEquals("Welcome Dzmitry!", getGreetingMessage());

        //soft assertion example
        assertAll(
                () -> assertEquals("Welcome Dzmitry!", getGreetingMessage())
                //,() -> assertEquals("Welcome John!", getGreetingMessage())
        );
    }

    @Nested
    class NegativeTests {

        @Test
        @DisplayName("User mustn't be login with invalid credentials")
        @Description("Logging into the app via sign on page. OInvalid credentials.")
        void invalidLogin() {
            navigateToApp();
            navigateToSignInPage();
            doLogin("test", "test");

            assertEquals("Invalid username or password. Signon failed.",
                    getMessageOnInvalidLogIn());

        }
    }
}