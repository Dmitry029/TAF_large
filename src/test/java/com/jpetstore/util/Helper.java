package com.jpetstore.util;


import io.qameta.allure.Attachment;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public static boolean isWedDriverManager() {

        return PropertyReader.getInstance().getProperty
                (PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager");
    }

    /**
     * Method to obtain app url from property file
     *
     * @return
     */
    public static String getAppUrl() {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        return baseUrl + port;
    }

    /**
     * Check property if page screenshot should be taken
     *
     * @param driver
     * @param name
     * @return
     */
    public static synchronized boolean takeScreenShot
    (WebDriver driver, String name) {

        boolean isScreenShot = PropertyReader.getInstance()
                .getProperty(PropKey.SCREEN_SHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if (isScreenShot) {
            attachScreenShot(driver, name);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to take screenshot
     *
     * @param driver
     * @param name
     * @return
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachScreenShot(WebDriver driver
            , String name) {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Check property if element screenshot should be taken
     *
     * @param element
     * @param name
     * @return
     */
    public static synchronized boolean takeElementScreenShot(WebElement element
            , String name) {

        String getElementScreenShot =
                SystemPropertyHelper.getElementScreenShotValue();

        if (getElementScreenShot.equalsIgnoreCase("ENABLE")) {
            attachElementScreenShot(element, name);
            return true;
        }
        return false;
    }

    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachElementScreenShot(WebElement element
            , String name) {

        return element.getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Method check if property to run test in remote (in grid) is true
     *
     * @return
     */
    public static boolean isRemote() {
        boolean isRemote = PropertyReader.getInstance()
                .getProperty(PropKey.REMOTE.getPropVal())
                .equalsIgnoreCase("TRUE");

        return isRemote;
    }

    /**
     * Method to return hub URL
     *
     * @return
     */
    public static String getHubUrl() {
        return PropertyReader.getInstance()
                .getProperty(PropKey.HUB_URL.getPropVal());
    }

    public static boolean getBrowserPath() {
        return SystemUtils.IS_OS_WINDOWS;
    }
}
