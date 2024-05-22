package org.foden.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    /**
     * Get xpath string.
     *
     * @param xpath the xpath
     * @param value the value
     * @return the string
     */
    public static String getXpath(String xpath, String value){
//        return xpath.replace("%replaceable%",value);
        return String.format(xpath,value);//a[text()='%s']
    }

    /**
     * Get xpath string.
     *
     * @param xpath  the xpath
     * @param value1 the value 1
     * @param value2 the value 2
     * @return the string
     */
    public static String getXpath(String xpath, String value1, String value2){
        return String.format(xpath,value1,value2);
    }
}
