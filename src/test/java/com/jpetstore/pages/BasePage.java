package com.jpetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static com.jpetstore.util.Helper.getAppUrl;

public class BasePage extends HtmlPageObject {

    private WebDriver driver;

    @FindBy(xpath = "//*[text()='Enter the Store']")
    WebElement enterTheStoreLink;

    @FindBy(xpath = "//*[text()='Sign In']")
    WebElement signInLink;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Open app
     */
    public void navigateToApp() {
        try {
            driver.navigate().to(new URL(getAppUrl()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public LoginPage navigateToSignInPage() {
        isTextPresentOnThePage("Welcome to JPetStore 6");
        clickLinkOrButton(enterTheStoreLink);
        clickLinkOrButton(signInLink);
        return new LoginPage(driver);
    }
}
