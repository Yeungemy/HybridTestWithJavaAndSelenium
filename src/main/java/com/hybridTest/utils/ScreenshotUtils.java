package com.hybridTest.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    public static byte[] captureScreenshotAsBytes(WebDriver driver) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            return takesScreenshot.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static void captureAndSaveScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            // Save the screenshot file, e.g., using FileUtils.copyFile
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
