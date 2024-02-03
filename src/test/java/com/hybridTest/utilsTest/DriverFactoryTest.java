package com.hybridTest.utilsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class DriverFactoryTest {

    public static WebDriver createDriver() {
        return createDriver(WebDriverTypesTest.CHROME);
    }

    public static WebDriver createDriver(WebDriverTypesTest browserType) {
        WebDriver driver;
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                // Safari driver doesn't need WebDriverManager setup
                driver = new SafariDriver();
                break;
            // Add other cases for additional browsers
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        // Additional configuration
        configureDriver(driver);

        return driver;
    }

    private static void configureDriver(WebDriver driver) {
        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
