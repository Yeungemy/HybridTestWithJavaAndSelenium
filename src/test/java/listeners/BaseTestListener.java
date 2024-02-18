package listeners;

import com.hybridTest.driver.DriverFactoryTest;
import com.hybridTest.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File; // Add this import
import java.io.IOException;

public class BaseTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("==============================================================================================");
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\u001B[32mPASSED\u001B[0m: " + convertToTitleCase(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("\u001B[31mFAILED\u001B[0m: " + convertToTitleCase(result.getMethod().getMethodName()));
        logScreenshot(result);
        logFailureDetails(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\u001B[33mSKIPPED\u001B[0m: " + convertToTitleCase(result.getMethod().getMethodName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        generateAllureReport();
        System.out.println("==============================================================================================");
    }

    private void logScreenshot(ITestResult result) {
        WebDriver driver = DriverFactoryTest.initializeDriver();
        byte[] screenshotBytes = ScreenshotUtils.captureScreenshotAsBytes(driver);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
    }

    private void logFailureDetails(ITestResult result) {
        Throwable throwable = result.getThrowable();
        StatusDetails statusDetails = new StatusDetails().setMessage(throwable.getMessage());
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setStatus(Status.FAILED));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setStatusDetails(statusDetails));
    }

    private String convertToTitleCase(String camelCaseString) {
        StringBuilder titleCase = new StringBuilder();
        boolean newWord = true;

        for (char ch : camelCaseString.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                if (!newWord) {
                    titleCase.append(" ");
                }
                titleCase.append(Character.toLowerCase(ch));
            } else {
                titleCase.append(ch);
            }
            newWord = Character.isWhitespace(ch) || ch == '_';
        }

        return titleCase.toString();
    }

    private void generateAllureReport() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("allure", "serve", "target/allure-results");
            processBuilder.directory(new File(System.getProperty("user.dir")));

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                System.err.println("Error: Allure report generation failed with exit code " + exitCode);
            } else {
                System.out.println("Allure report generated successfully");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: Failed to generate Allure report");
            e.printStackTrace();
        }
    }

}
