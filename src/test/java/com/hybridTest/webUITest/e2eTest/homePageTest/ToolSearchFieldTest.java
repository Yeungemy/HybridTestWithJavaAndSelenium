package com.hybridTest.webUITest.e2eTest.homePageTest;

import com.hybridTest.webUITest.pageObjectsTest.homePageTest.ToolSearchSectionTest;
import utilsTest.ActionUtilsTest;
import com.hybridTest.webUITest.e2eTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolSearchFieldTest extends BaseTest {

    @Test
    public void verifyToolSearchField() {
        ToolSearchSectionTest toolSearchSection = new ToolSearchSectionTest(driver);

        String searchString = "***Combination Pliers1";
        ActionUtilsTest.fillInputField(toolSearchSection.searchInputField, searchString);

        String inputFieldValue = toolSearchSection.searchInputField.getAttribute("value");

        // Assert the input field value
        Assert.assertEquals(inputFieldValue, searchString);
    }
}
