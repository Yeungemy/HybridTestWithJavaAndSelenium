package com.hybridTest.webTest;

import pageObjectsTest.BasePageTest;
import utilsTest.DriverFactoryTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver driver;
    protected static BasePageTest basePage;

    @BeforeSuite
    public void setUpDriver() {
        // Set up WebDriver using the default browser (Chrome)
        driver = DriverFactoryTest.createDriver();

        // Initialize BasePage
        basePage = new BasePageTest(driver);
    }

    @BeforeClass
    public void launchTestPlatform() {
        basePage.launchWebTestPlatform();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}