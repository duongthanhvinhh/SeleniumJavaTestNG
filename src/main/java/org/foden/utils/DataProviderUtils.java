package org.foden.utils;

import org.foden.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Data provider utils.
 */
public class DataProviderUtils {

    private static List<Map<String,String>> list = new ArrayList<>();

    /**
     * Get data object [ ].
     *
     * @param m the m
     * @return the object [ ]
     */
    @DataProvider
    public static Object[] getData(Method m){

        String testname = m.getName();
        //Use if condition here to avoid the ExcelUtils.getTestDetails being called multiple times
        if (list.isEmpty()){
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
        }
        List<Map<String, String>> smalllist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname)&&
                    list.get(i).get("execute").equalsIgnoreCase("yes")){
                smalllist.add(list.get(i));
            }
        }
//        list.removeAll(smalllist);

        return smalllist.toArray();
    }
}
