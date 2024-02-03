package com.hybridTest.utilsTest;

import com.hybridTest.pageObjectsTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtilsTest extends BasePageTest {
    public WaitUtilsTest(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void waitForContentInInputField(WebElement webEl, String expectedContent) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(webEl, expectedContent));
    }

    public static void waitForClickable(WebElement webEl){
        wait.until(ExpectedConditions.elementToBeClickable(webEl));
    }

    public static void waitAndClick(WebElement webEl){
        wait.until(ExpectedConditions.elementToBeClickable(webEl));
        webEl.click();
    }
}
