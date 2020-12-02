package com.jpetstore.test;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.BasePage;
import org.junit.jupiter.api.Test;

public class LoginTest extends DriverManager {

    @Test
    void doLogin() {
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToApp();
        basePage.navigateToSignInPage();
    }
}
