package com.hybridTest.pageObjectOfModels.webUiTestPages;

import com.hybridTest.config.ConfigReaderTest;
import com.hybridTest.utils.WaitUtilsE2eTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageTest {
    protected static WebDriverWait wait;
    protected final String WEB_TEST_PLATFORM_NAME = "web_test_url";
    @FindBy(tagName = "body")
    public WebElement pageBodyTag;
    protected WebDriver driver;

    // Constructor to initialize WebDriver and WebDriverWait
    public BasePageTest(WebDriver driver) {
        this.driver = driver;
        maximizeWindow();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void launchWebTestPlatform() {
        navigateTo(ConfigReaderTest.getTestPlatformUrl(WEB_TEST_PLATFORM_NAME));
    }

    // Common method to open a URL
    public void navigateTo(String url) {
        driver.get(url);
        // Dynamically wait for the body to be present
        WaitUtilsE2eTest.waitElementToBeVisible(pageBodyTag);
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