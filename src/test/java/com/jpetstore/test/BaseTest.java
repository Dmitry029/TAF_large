package com.jpetstore.test;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    static WebDriver driver;
    static PropertyReader prop = PropertyReader.getInstance();


    @BeforeAll
    public static void init() {

        if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equals("FIREFOX")) {

            if (prop.getProperty(PropKey.BROWSER_MANAGER.getPropVal())
                    .equalsIgnoreCase("webDriverManager")) {

                WebDriverManager.firefoxdriver().setup();
            } else {
                System.setProperty("webdriver.gecko.driver",
                        "src/test/resources/drivers/windows/geckodriver.exe");
            }
            driver = new FirefoxDriver();


        } else if (prop.getProperty(PropKey.BROWSER.getPropVal())
                .equals("CHROME")) {

            if (prop.getProperty(PropKey.BROWSER_MANAGER.getPropVal())
                    .equalsIgnoreCase("webDriverManager")) {

                WebDriverManager.chromedriver().setup();
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/drivers/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
    }

    @AfterAll
    public static void cleanUp() {
        driver.quit();
    }
}
