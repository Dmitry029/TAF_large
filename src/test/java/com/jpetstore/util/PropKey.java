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
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    //Screenshot
    SCREEN_SHOT("screenShot"),
    ELEMENT_SCREEN_SHOT("elementScreenShot"),

    //Allure report
    ALLURE_REPORT_STEP_LOG("allureReportStepLog"),

    //Selenium grid
    REMOTE("remote"),
    HUB_URL("hubUrl");



    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
