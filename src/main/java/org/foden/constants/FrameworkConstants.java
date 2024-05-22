package org.foden.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {
    private FrameworkConstants() {

    }
    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final String JSONFILEPATH = RESOURCEPATH + "/config/config.json";
    private static final String EXCELPATH = RESOURCEPATH + "/excel/testdata.xlsx";

    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";

    private static final String TODAYDATETIME = new SimpleDateFormat("MMM-dd-yyyy_HH_mm_ss_SSS").format(new Date());

    private static final int EXPLICITWAIT = 10;
    private static final int WAITPAGELOADED = 20;
    private static final int WAITSLEEPSTEP = 0;

    private static final boolean ACTIVEPAGELOADED = true;

    private static final String ITERATIONDATASHEET = "DATA";

    public static int getExplicitwait() {return EXPLICITWAIT;}

    public static int getWaitpageloaded() {
        return WAITPAGELOADED;
    }

    public static int getWaitsleepstep() {
        return WAITSLEEPSTEP;
    }

    public static boolean isActivepageloaded() {return ACTIVEPAGELOADED;}

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getJsonfilepath() {
        return JSONFILEPATH;
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static String getIterationdatasheet() {return ITERATIONDATASHEET;}

    public static String getTodayDateTime() {
        return TODAYDATETIME;
    }

}
