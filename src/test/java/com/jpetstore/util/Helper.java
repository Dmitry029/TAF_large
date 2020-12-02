package com.jpetstore.util;


public class Helper {

    public static boolean isWedDriverManager(){

        return PropertyReader.getInstance().getProperty
                (PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager");
    }

    /**
     * Method to obtain app url from property file
     * @return
     */
    public static String getAppUrl(){
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        return baseUrl + port;
    }
}
