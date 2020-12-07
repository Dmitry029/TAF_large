package com.jpetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private WebDriver driver = getDriver();

    @FindBy(css = "input[name='username']")
    WebElement userNameWindow;

    @FindBy(css = "input[name='password']")
    WebElement passwordWindow;

    @FindBy(css = "input[value=Login]")
    WebElement loginButton;

    @FindBy(xpath = "//*[text()='Register Now!']")
    WebElement registerNowLink;

    @FindBy(css = ".messages li")
    WebElement invalidLogInMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage doLogin(String userName, String password) {

        enterTextIntoTextBox(userNameWindow, userName);
        enterTextIntoTextBox(passwordWindow, password);
        loginButton.click();

        return new DashboardPage(driver);
    }

    public AccountPage navigateRegistrationPage() {
        registerNowLink.click();
        return new AccountPage(driver);
    }

    public String getMessageOnInvalidLogIn() {
        return invalidLogInMessage.getText();
    }

}
