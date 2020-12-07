package com.jpetstore.test;

import com.jpetstore.driver.DriverManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.jpetstore.util.PropKey.PORT;
import static com.jpetstore.util.PropKey.URL;

@Disabled
@DisplayName("My browser tests")
public class MyFirstTest extends DriverManager {

    @Test
    @DisplayName("This is my first Junit5 test")
    void launchBrowser() {

        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());
        String finalUrl = url + port;

        driver.get(finalUrl);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
