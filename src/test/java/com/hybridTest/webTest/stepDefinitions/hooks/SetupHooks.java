package com.hybridTest.webTest.stepDefinitions.hooks;

import com.hybridTest.driver.DriverFactoryTest;
import com.hybridTest.pageObjectOfModels.webUiTestPages.BasePageTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SetupHooks {
    protected static WebDriver driver;
    protected static BasePageTest basePage;
    private static String currentFeature;

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.getStatus() == Status.FAILED) {
            // Take a screenshot or perform other actions for failure handling
            captureScreenshot(scenario);
        }
    }

    @Before
    public void setUp(Scenario scenario) {
        String featureName = scenario.getUri().toString();
        if (!featureName.equals(currentFeature)) {
            currentFeature = featureName;
            setUpFeature();
        }
    }

    @After(order = 1) // This will run after the scenario but before the tear-down feature
    public void tearDownScenario(Scenario scenario) {
        System.out.println("Finished feature: " + currentFeature);

        // Clean up WebDriver after each scenario
        DriverFactoryTest.quitDriver();
    }

    private void setUpFeature() {
        // Set up WebDriver using the default browser (Chrome)
        driver = DriverFactoryTest.initializeDriver();

        // Initialize BasePage for the feature
        basePage = new BasePageTest(driver);

        // Perform any feature-level setup tasks here
        System.out.println("Starting feature: " + currentFeature);

        // launch on the test platform
        basePage.launchWebTestPlatform();

        // Set implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void captureScreenshot(Scenario scenario) {
        // Take a screenshot using WebDriver and attach it to the scenario
        if (driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailureScreenshot");
        } else {
            System.out.println("Driver does not support screenshots.");
        }
    }
}
