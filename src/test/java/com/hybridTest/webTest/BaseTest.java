package com.hybridTest.webTest;

import com.hybridTest.pageObjectsTest.BasePageTest;
import com.hybridTest.utilsTest.DriverFactoryTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected BasePageTest basePage;

    @BeforeClass
    public void setUpDriver() {
        // Set up WebDriver using the default browser (Chrome)
        driver = DriverFactoryTest.createDriver();

        // Initialize BasePage
        basePage = new BasePageTest(driver);
    }

    @BeforeMethod
    public void launchTestPlatform() {
        basePage.launchWebTestPlatform();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}