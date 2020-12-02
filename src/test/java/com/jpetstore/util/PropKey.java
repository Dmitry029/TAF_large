package com.jpetstore.util;

public enum PropKey {

    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),

    //Driver paths
    CHROME_DRIVER_PATH("chromeDriverPath"),
    GECKO_DRIVER_PATH("geckoDriverPath"),

    //Timeouts
    IMPLICIT_WAIT("implicitWait");



    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
