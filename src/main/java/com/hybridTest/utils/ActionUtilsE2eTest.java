package com.hybridTest.utils;

import org.openqa.selenium.WebElement;

public class ActionUtilsE2eTest {
    public static void fillInputField(WebElement webEl, String content) {
        webEl.sendKeys(content);
        WaitUtilsE2eTest.waitForTextPresentedInInputField(webEl, content);
    }
}