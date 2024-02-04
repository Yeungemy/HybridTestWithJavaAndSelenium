package com.hybridTest.webTest;

import com.hybridTest.pageObjectOfModels.webUiTestPages.BasePageTest;
import com.hybridTest.driver.DriverFactoryTest;
import listeners.WebUiTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
@Listeners(WebUiTestListener.class)

public class BaseWebUiTest {
    protected static WebDriver driver;
    protected static BasePageTest basePage;

    @BeforeSuite
    public void setUpDriver() {
        // Set up WebDriver using the default browser (Chrome)
        driver = DriverFactoryTest.getDriver();

        // Initialize BasePage
        basePage = new BasePageTest(driver);
    }

    @BeforeClass
    public void launchTestPlatform() {
        basePage.launchWebTestPlatform();
    }

    @AfterSuite
    public void tearDown() {
        DriverFactoryTest.quitDriver();
    }
}