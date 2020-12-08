package com.jpetstore.steps;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.AccountPage;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.DashboardPage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.util.Helper;
import io.qameta.allure.Step;


public class JPetStoreSteps extends DriverManager {

    private BasePage basePage = new BasePage(getDriver());
    private LoginPage loginPage = new LoginPage(getDriver());
    private DashboardPage dashboardPage = new DashboardPage(getDriver());
    private AccountPage accountPage = new AccountPage(getDriver());


    //BASE PAGE STEPS
    @Step("Navigation to JPetStore Application")
    public void navigateToApp() {
        basePage.navigateToApp();
    }

    @Step("Navigating to Login Page")
    public LoginPage navigateToSignInPage() {
        return basePage.navigateToSignInPage();
    }

    @Step
    public LoginPage clickSignInLink() {
        return basePage.clickSignInLink();
    }


    //LOGIN PAGE STEPS
    @Step("Logging in with username: {0} & password: {1}")
    public DashboardPage doLogin(String userName, String password) {
        basePage.clickSignInLink();
        Helper.takeScreenShot(driver, "doLogin");
        return loginPage.doLogin(userName, password);
    }

    @Step("Return message on invalid login")
    public String getMessageOnInvalidLogIn() {
        return loginPage.getMessageOnInvalidLogIn();
    }


    //DASHBOARD STEPS
    @Step
    public AccountPage navigateRegistrationPage() {
        return loginPage.navigateRegistrationPage();
    }

    @Step("Get greeting message")
    public String getGreetingMessage() {
        return dashboardPage.getGreetingMessage();
    }

    //ACCOUNTS PAGE STEPS
    @Step
    public AccountPage setNewUserInformation(String userName
            , String password, String repeatPassword) {
        return accountPage.setNewUserInformation(userName, password, repeatPassword);
    }

    @Step
    public AccountPage addAccountInformation(
            String firstName,
            String lastName,
            String email,
            String phone,
            String addr1,
            String addr2,
            String city,
            String state,
            String zipCode,
            String country) {
        return accountPage.addAccountInformation(firstName,
                lastName, email, phone, addr1, addr2,
                city, state, zipCode, country);
    }

    @Step
    public AccountPage addProfileInformation(String language,
            String category,
            boolean myList,
            boolean myBanner) {
        return accountPage.addProfileInformation(language, category,
                myList, myBanner);
    }

    @Step
    public DashboardPage clickSaveAccountInformation() {
        return accountPage.clickSaveAccountInformation();
    }
}
