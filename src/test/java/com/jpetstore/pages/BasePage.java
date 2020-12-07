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

    @FindBy(css = "#Logo img")
    WebElement logoLink;

    @FindBy(css = "#MenuContent [name=img_cart]")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//*[text()='?']")
    WebElement helpLink;

    @FindBy(css = "#SearchContent input[type='text']")
    WebElement searchInputWindow;

    @FindBy(css = "#SearchContent input[type='submit']")
    WebElement searchSubmitButton;


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

    /**
     * Click on Sign in link
     *
     * @return
     */
    public LoginPage clickSignInLink() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public DashboardPage navigateToDashboard() {
        logoLink.click();
        return new DashboardPage(driver);
    }

    public ProductsPage navigateToShoppingCart() {
        shoppingCartLink.click();
        return new ProductsPage(driver);
    }

    public HelpPage navigateToHelpPage() {
        helpLink.click();
        return new HelpPage(driver);
    }

    public ProductsPage searchForProduct(String searchValue) {
        enterTextIntoTextBox(searchInputWindow, searchValue);
        searchSubmitButton.click();
        return new ProductsPage(driver);
    }

    public DashboardPage signOut() {
        //TODO
        return new DashboardPage(driver);
    }

    public AccountPage navigateToAccountPage() {
        //TODO
        return new AccountPage(driver);
    }

    public ProductsPage navigateTOProductCategory(PetCategories productCategories) {
        ProductsPage toReturn = null;

        switch (productCategories) {
            case FISH:
                //click
                toReturn = new ProductsPage(driver);
                break;
            case CATS:
                //click
                toReturn = new ProductsPage(driver);
                break;
            case DOGS:
                //click
                toReturn = new ProductsPage(driver);
                break;
            case BIRDS:
                //click
                toReturn = new ProductsPage(driver);
                break;
            case REPTILES:
                //click
                toReturn = new ProductsPage(driver);
                break;
            default:
                break;
        }
        return toReturn;
    }
}
