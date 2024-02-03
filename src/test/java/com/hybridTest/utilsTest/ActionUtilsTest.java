package com.hybridTest.utilsTest;

import org.openqa.selenium.WebElement;

public class ActionUtilsTest {
    public static void fillInputField(WebElement webEl, String content) {
        webEl.sendKeys(content);
        WaitUtilsTest.waitForContentInInputField(webEl, content);
    }
}