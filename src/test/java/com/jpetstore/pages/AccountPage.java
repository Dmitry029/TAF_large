package com.jpetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    private WebDriver driver = getDriver();

    @FindBy(css = "[name=username]")
    WebElement userNameWindow;

    @FindBy(css = "[name=password]")
    WebElement passwordWindow;

    @FindBy(css = "[name=repeatedPassword]")
    WebElement repeatedPasswordWindow;

    @FindBy(css = "[name='account.firstName']")
    WebElement firstNameWindow;

    @FindBy(css = "[name='account.lastName']")
    WebElement lastNameWindow;

    @FindBy(css = "[name='account.email']")
    WebElement emailWindow;

    @FindBy(css = "[name='account.phone']")
    WebElement phoneWindow;

    @FindBy(css = "[name='account.address1']")
    WebElement address1Window;

    @FindBy(css = "[name='account.address2']")
    WebElement address2Window;

    @FindBy(css = "[name='account.city']")
    WebElement cityWindow;

    @FindBy(css = "[name='account.state']")
    WebElement stateWindow;

    @FindBy(css = "[name='account.zip']")
    WebElement zipWindow;

    @FindBy(css = "[name='account.country']")
    WebElement countryWindow;

    @FindBy(css = "[name='account.languagePreference']")
    WebElement languagePrefWindow;

    @FindBy(css = "[name='account.favouriteCategoryId']")
    WebElement favoriteCategoryWindow;

    @FindBy(css = "[name='account.listOption']")
    WebElement myListCheckbox;

    @FindBy(css = "[name='account.bannerOption']")
    WebElement myBannerCheckbox;

    @FindBy(css = "[name='newAccount")
    WebElement saveAccountButton;


    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * @param userName
     * @param password
     * @param repeatPassword
     * @return
     */
    public AccountPage setNewUserInformation(String userName
            , String password, String repeatPassword) {
        isTextPresentOnThePage("User Information");

        enterTextIntoTextBox(userNameWindow, userName);
        enterTextIntoTextBox(passwordWindow, password);
        enterTextIntoTextBox(repeatedPasswordWindow, repeatPassword);

        return this;
    }

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

        isTextPresentOnThePage("Account Information");

        enterTextIntoTextBox(firstNameWindow, firstName);
        enterTextIntoTextBox(lastNameWindow, lastName);
        enterTextIntoTextBox(emailWindow, email);
        enterTextIntoTextBox(phoneWindow, phone);
        enterTextIntoTextBox(address1Window, addr1);
        enterTextIntoTextBox(address2Window, addr2);
        enterTextIntoTextBox(cityWindow, city);
        enterTextIntoTextBox(stateWindow, state);
        enterTextIntoTextBox(zipWindow, zipCode);
        enterTextIntoTextBox(countryWindow, country);
        return this;
    }

    public AccountPage addProfileInformation(String language,
            String category,
            boolean myList,
            boolean myBanner) {

        isTextPresentOnThePage("Profile Information");

        selectByVisibleText(languagePrefWindow, language);
        selectByVisibleText(favoriteCategoryWindow, category);
        selectCheckbox(myListCheckbox);
        selectCheckbox(myBannerCheckbox);

        return this;
    }

    public DashboardPage clickSaveAccountInformation(){
        saveAccountButton.click();
        return new DashboardPage(driver);
    }
}
