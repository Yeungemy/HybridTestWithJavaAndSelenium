package com.hybridTest.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class DriverFactoryTest {
    private static WebDriver driver;

    private DriverFactoryTest() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    /**
     * retrieves (mvn test -D browser=firefox) the value of the system property named "browser."
     * The getProperty method is used to get the value of a system property,
     * and in this case, it checks if the "browser" property is set.
     * the default value is set to "chrome."
     */
    private static void initializeDriver() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }

        // Window maximization
        driver.manage().window().maximize();

        // Set implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Set page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
