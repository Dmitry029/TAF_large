package com.jpetstore.test;

import com.jpetstore.steps.JPetStoreSteps;
import com.jpetstore.util.ExcelDataReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginDDTest extends JPetStoreSteps {

    static Object[][] getDataFordoLoginTest() {
        return ExcelDataReader.getData("src/test/resources/data/LoginDDTest.xlsx"
                , "doLogin");
    }

    @Tag(SMOKE)
    @ParameterizedTest
    @DisplayName("Login to application and verify greeting message")
    @MethodSource("getDataFordoLoginTest")

    void doLogin(String userName, String password, String expectedResult) {
        navigateToApp();
        navigateToSignInPage();
        doLogin(userName, password);
        assertEquals(expectedResult, getGreetingMessage());
    }
}
