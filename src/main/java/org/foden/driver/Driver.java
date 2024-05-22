package org.foden.driver;

import org.foden.enums.ConfigProperties;
import org.foden.exceptions.BrowserInvocationFailedException;
import org.foden.factories.DriverFactory;
import org.foden.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

/**
 * March 04, 2024
 *
 * @author Foden Automation
 * @version 1.0
 * @see DriverManager
 * @since 1.0
 */

public final class Driver {

    private Driver(){}

    public static void initDriver(){
        if (Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.setDriver(DriverFactory.getDriver());
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Browser invocation failed. Please check the capabilities of browser");
            }
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

    public static void closeDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().close();
        }

    }
}
