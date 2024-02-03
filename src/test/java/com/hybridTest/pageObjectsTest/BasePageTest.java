package com.hybridTest.pageObjectsTest;

import com.hybridTest.utilsTest.ConfigReaderTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageTest {
    protected WebDriver driver;
    protected static WebDriverWait wait;
    protected final String WEB_TEST_PLATFORM_NAME = "web_test_url";

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePageTest(WebDriver driver) {
        this.driver = driver;
        maximizeWindow();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void launchWebTestPlatform() {
        String webTestPlatformUrl = ConfigReaderTest.getTestPlatformUrl(WEB_TEST_PLATFORM_NAME);
        navigateTo(webTestPlatformUrl);
    }

    // Common method to open a URL
    public void navigateTo(String url) {
        driver.get(url);
        // Dynamically wait for the body to be present
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    // Common method to get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Common method to navigate back
    public void navigateBack() {
        driver.navigate().back();
    }
}