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

public class SetupHooks {
    protected static WebDriver driver;
    protected static BasePageTest basePage;
    private static String currentFeature;

    @Before
    public void setUp(Scenario scenario) {
        String featureName = scenario.getUri().toString();
        if (!featureName.equals(currentFeature)) {
            currentFeature = featureName;
            setUpFeature();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.getStatus() == Status.FAILED) {
            // Take a screenshot or perform other actions for failure handling
            captureScreenshot(scenario);
        }
        String featureName = scenario.getUri().toString();
        if (!featureName.equals(currentFeature)) {
            currentFeature = null;
            tearDownFeature();
        }
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
    }

    private void tearDownFeature() {
        // Clean up WebDriver after the feature
        quitDriver();

        // Perform any feature-level tear down tasks here
        System.out.println("Finished feature: " + currentFeature);
    }

    public static void quitDriver() {
        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
        driver = null;
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
