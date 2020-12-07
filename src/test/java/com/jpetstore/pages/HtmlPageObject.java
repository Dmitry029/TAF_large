package com.jpetstore.pages;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.jpetstore.util.TimeUtil.getExplicitWait;

public class HtmlPageObject extends DriverManager {

    private WebDriver driver = getDriver();

    /**
     * Method to find element by css
     *
     * @param cssLocator
     * @return
     */
    public WebElement findElementByCss(String cssLocator) {
        By by = By.cssSelector(cssLocator);
        return findElementBy(by);
    }

    /**
     * Method to find element by xpath
     *
     * @param xpathLocator
     * @return
     */
    public WebElement findElementByXpath(String xpathLocator) {
        By by = By.xpath(xpathLocator);
        return findElementBy(by);
    }

    /**
     * Method to find element by using By object
     *
     * @param by
     * @return
     */
    public WebElement findElementBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Method to find list of web elements using By object
     *
     * @param by
     * @return
     */
    public List<WebElement> findElementsBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWait()));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    /**
     * Methods to enter text inside text box
     *
     * @param by
     * @param text
     */
    public void enterTextIntoTextBox(By by, String text) {
        WebElement textBox = findElementBy(by);
        enterTextIntoTextBox(textBox, text);
    }

    public void enterTextIntoTextBox(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        Helper.takeElementScreenShot(element, "textBox");
    }

    /**
     * Methods to click a link or button
     *
     * @param by
     */
    public void clickLinkOrButton(By by) {
        findElementBy(by).click();
    }

    public void clickLinkOrButton(WebElement element) {
        element.click();
    }

    /**
     * Methods to return text
     *
     * @param by
     * @return
     */
    public String getTextFromElement(By by) {
        return findElementBy(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    /**
     * Methods ro return the attribute value
     *
     * @param by
     * @param attributeName
     * @return
     */
    public String getAttribute(By by, String attributeName) {
        return findElementBy(by).getAttribute(attributeName);
    }

    public String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    /**
     * Method to select by visible text
     *
     * @param by
     * @param textValue
     */
    public void selectByVisibleText(By by, String textValue) {
        WebElement selectBox = findElementBy(by);
        selectByVisibleText(selectBox, textValue);
    }

    public void selectByVisibleText(WebElement selectBox, String textValue) {
        Select select = new Select(selectBox);
        select.selectByVisibleText(textValue);
    }

    /**
     * Method to select checkbox
     *
     * @param by
     * @return
     */
    public boolean selectCheckbox(By by) {
        WebElement webElement = findElementBy(by);
        return selectCheckbox(webElement);
    }

    public boolean selectCheckbox(WebElement element) {

        if (!element.isSelected()) {
            element.click();
        }
        return true;
    }

    /**
     * Method to check if text is present on the page
     * @param text
     * @return
     */
    public boolean isTextPresentOnThePage(String text) {
        return driver.getPageSource().contains(text);
    }
}
