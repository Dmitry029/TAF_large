package com.jpetstore.util;

public class TimeUtil {

    /**
     * Method to return implicit wait
     * @return
     */
    public static long getImplicitWait(){
        return Long.parseLong(PropertyReader.getInstance()
                .getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }
}
