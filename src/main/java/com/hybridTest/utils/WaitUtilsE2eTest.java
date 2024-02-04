package com.hybridTest.utils;

import com.hybridTest.pageObjectOfModels.webUiTestPages.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtilsE2eTest extends BasePageTest {
    public WaitUtilsE2eTest(WebDriver driver) {
        super(driver);
    }

    public static void waitForTextPresentedInInputField(WebElement webEl, String expectedContent) {
        BasePageTest.wait.until(ExpectedConditions.textToBePresentInElementValue(webEl, expectedContent));
    }

    public static void waitForClickable(WebElement webEl) {
        BasePageTest.wait.until(ExpectedConditions.elementToBeClickable(webEl));
    }

    public static void waitAndClick(WebElement webEl) {
        waitForClickable(webEl);
        webEl.click();
    }

    public static void waitElementToBeVisible(WebElement webEl) {
        BasePageTest.wait.until(ExpectedConditions.visibilityOf(webEl));
    }
}
