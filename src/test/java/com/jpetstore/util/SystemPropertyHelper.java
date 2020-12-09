package com.jpetstore.util;

public class SystemPropertyHelper {

    /**
     * Method for get value for elementScreenShot
     *
     * @return
     */
    public static String getElementScreenShotValue() {
        String msg = "";
        String valueFromPropertyFile = PropertyReader.getInstance()
                .getProperty(PropKey.ELEMENT_SCREEN_SHOT.getPropVal());

        String valueFromSystemVariable = System.getProperty("elementScreenShot");

        if (valueFromSystemVariable.length() > 0) {
            if (valueFromSystemVariable.equalsIgnoreCase("ENABLE") ||
                    valueFromSystemVariable.equalsIgnoreCase("DISABLE")) {

                return valueFromSystemVariable;
            } else {
                System.out.println("Invalid value from System property: " + valueFromSystemVariable);
            }
        }
        System.out.println("No system property specified." +
                "The property from property file is taken: " + valueFromPropertyFile);

        return valueFromPropertyFile;
    }

}
