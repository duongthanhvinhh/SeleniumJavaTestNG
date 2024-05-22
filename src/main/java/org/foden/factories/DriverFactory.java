package org.foden.factories;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver() throws MalformedURLException {

        WebDriver driver = null;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        String runMode = PropertyUtils.get(ConfigProperties.RUNMODE);

        String browser = PropertyUtils.get(ConfigProperties.BROWSER);

        String headless = PropertyUtils.get(ConfigProperties.HEADLESS);

            if(Objects.isNull(DriverManager.getDriver())){
                switch (browser.toLowerCase()){
                    case "edge":
                        final EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--disable-dev-shm-usage");
                        edgeOptions.addArguments("--disable-gpu");
                        edgeOptions.addArguments("--window-size","1920,1080");
                        if (Objects.equals(headless, "yes")){
                            edgeOptions.addArguments("headless");
                        }
                        if (runMode.equalsIgnoreCase("remote")) {

                            desiredCapabilities.setCapability("browserName", "MicrosoftEdge");
                            desiredCapabilities.setCapability("browserVersion", "101.0");
                            desiredCapabilities.setCapability("screenResolution", "1920x1080x24");
                            desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true)); // If this cap isn't specified, it will just get any available one
                            desiredCapabilities.setCapability("videoName", "EdgeRecorded_"+FrameworkConstants.getTodayDateTime()+".mp4");
                            desiredCapabilities.setCapability("build", "Automation Test");
                            desiredCapabilities.setCapability("name", "Regression Test");
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENOIDURL)), desiredCapabilities);

                        } else {
                            WebDriverManager.edgedriver().clearDriverCache();
                            WebDriverManager.edgedriver().setup();
                            driver = new EdgeDriver(edgeOptions);
                        }
                        break;

                    case "chrome":
                        final ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size","1920,1080");
                        if (Objects.equals(headless, "yes")){
                            chromeOptions.addArguments("--headless=new");
                        }
                        if (runMode.equalsIgnoreCase("remote")) {
                            desiredCapabilities.setCapability("browserName", "chrome");
                            desiredCapabilities.setCapability("browserVersion", "102.0");
                            desiredCapabilities.setCapability("screenResolution", "1920x1080x24");
                            desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true)); // If this cap isn't specified, it will just get any available one
                            desiredCapabilities.setCapability("videoName", "ChromeRecorded_"+FrameworkConstants.getTodayDateTime()+".mp4");
                            desiredCapabilities.setCapability("build", "Automation Test");
                            desiredCapabilities.setCapability("name", "Regression Test");
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENOIDURL)), desiredCapabilities);
                            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

                        } else {
                            WebDriverManager.chromedriver().clearDriverCache();
                            WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver(chromeOptions);
                        }
                        break;

                    case "firefox":
                        final FirefoxOptions firefoxOptions = new FirefoxOptions();
                        if (Objects.equals(headless, "yes")){
                            firefoxOptions.addArguments("--headless=new");
                        }
                        final FirefoxProfile profile = new FirefoxProfile();

                        firefoxOptions.addArguments("--disable-web-security");
                        firefoxOptions.addArguments("--allow-running-insecure-content");
                        firefoxOptions.addArguments("--no-sandbox");
                        firefoxOptions.addArguments("--disable-dev-shm-usage");
                        firefoxOptions.addArguments("--disable-gpu");
                        firefoxOptions.addArguments("--window-size","1920,1080");
                        profile.setAcceptUntrustedCertificates(true);
                        profile.setAssumeUntrustedCertificateIssuer(false);
                        profile.setPreference("pageLoadStrategy", "normal");
                        firefoxOptions.setProfile(profile);

                        if (runMode.equalsIgnoreCase("remote")) {
                            desiredCapabilities.setCapability("browserName", "firefox");
                            desiredCapabilities.setCapability("browserVersion", "100.0");
                            desiredCapabilities.setCapability("videoName", "FireFoxRecorded_"+ FrameworkConstants.getTodayDateTime()+".mp4");
                            desiredCapabilities.setCapability("screenResolution", "1920x1080x24");
                            desiredCapabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true)); // If this cap isn't specified, it will just get any available one
                            desiredCapabilities.setCapability("build", "Automation Test");
                            desiredCapabilities.setCapability("name", "Regression Test");
                            driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENOIDURL)), desiredCapabilities);
                            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));

                        } else {
                            WebDriverManager.firefoxdriver().clearDriverCache();
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver(firefoxOptions);
                        }
                        break;
                }
            }
            return driver;
    }
}


