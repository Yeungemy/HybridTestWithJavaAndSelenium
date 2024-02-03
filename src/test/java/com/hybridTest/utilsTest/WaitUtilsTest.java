package com.hybridTest.utilsTest;

import com.hybridTest.pageObjectsTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtilsTest extends BasePageTest {
    public WaitUtilsTest(WebDriver driver) {
        super(driver);
    }

    public static void waitForTextPresentedInInputField(WebElement webEl, String expectedContent) {
        BasePageTest.wait.until(ExpectedConditions.textToBePresentInElementValue(webEl, expectedContent));
    }

    public static void waitForClickable(WebElement webEl){
        BasePageTest.wait.until(ExpectedConditions.elementToBeClickable(webEl));
    }

    public static void waitAndClick(WebElement webEl){
        waitForClickable(webEl);
        webEl.click();
    }

    public static void waitElementToBeVisible(WebElement webEl){
        wait.until(ExpectedConditions.visibilityOf(webEl));
    }
}
