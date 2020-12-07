package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * Method to get WebDriver
     *
     * @return
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driverThreadLocal.set(getBrowser().getWebDriver());
        }

        driverThreadLocal.get().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(getImplicitWait()));

        return driverThreadLocal.get();
    }

    /**
     * Method to quit WebDriver
     */
    public static void quiteDriver() {
        driverThreadLocal.get().quit();
    }


    /**
     * Determine browser
     *
     * @return
     */
    private static BrowserType getBrowser() {
        if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("CHROME")) {

            return BrowserType.CHROME;

        } else if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("FIREFOX")) {

            return BrowserType.FIREFOX;
        } else {
            return BrowserType.CHROME; // default browser
        }
    }
}
