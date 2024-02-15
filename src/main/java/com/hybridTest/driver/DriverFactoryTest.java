package com.hybridTest.driver;

import com.hybridTest.config.ConfigReaderTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.time.Duration;

public class DriverFactoryTest {
    private static WebDriver driver;
    private static final Boolean isHeadless = ConfigReaderTest.isHeadless();
    private static final String browser = ConfigReaderTest.getWebBrowser("web_browser");

    private DriverFactoryTest() {
    }

    public static WebDriver initializeDriver() {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                // Add additional options if needed
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions options=new EdgeOptions();
                if (isHeadless) {
                    options.addArguments("--headless");
                }
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

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
