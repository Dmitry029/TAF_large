package com.jpetstore.test;


import com.jpetstore.steps.JPetStoreSteps;
import com.jpetstore.util.TestListener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)
public class RegistrationParametrisedTest extends JPetStoreSteps {

    @Disabled
    @ParameterizedTest
    @DisplayName("Register multiple users to the pet store and verify" +
            "if new users can login")

    @CsvFileSource(resources = "/data/registration-test.csv", numLinesToSkip = 1)
    void addNewUserToStoreAndVerifyLogin(
            String userName,
            String password,
            String repeatPassword,
            String firstName,
            String lastName,
            String email,
            String phone,
            String addr1,
            String addr2,
            String city,
            String state,
            String zipCode,
            String country
    ) {

        navigateToApp();
        navigateToSignInPage();
        navigateRegistrationPage();

        setNewUserInformation(userName, password, repeatPassword);
        addAccountInformation(firstName, lastName, email, phone, addr1, addr2,
                city, state, zipCode, country);

        addProfileInformation("english", "CATS", true, true);
        clickSaveAccountInformation();


        //Login & verify account creation
        doLogin(userName, password);
        String greetingMsg = getGreetingMessage();

        assertEquals("Welcome " + firstName + "!", greetingMsg);
    }

}
