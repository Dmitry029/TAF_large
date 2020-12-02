package com.jpetstore.util;


public class Helper {

    public static boolean isWedDriverManager(){

        return PropertyReader.getInstance().getProperty
                (PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager");
    }
}
