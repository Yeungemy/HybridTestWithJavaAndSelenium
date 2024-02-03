package com.hybridTest.webTest.homePageTest;

import com.hybridTest.pageObjectsTest.homePageTest.ToolSearchSectionTest;
import com.hybridTest.utilsTest.ActionUtilsTest;
import com.hybridTest.webTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolSearchFieldTest extends BaseTest {

    @Test
    public void verifyToolSearchField() {
        ToolSearchSectionTest toolSearchSection = new ToolSearchSectionTest(driver);

        String searchString = "Combination Pliers";
        ActionUtilsTest.fillInputField(toolSearchSection.searchInputField, searchString);

        String inputFieldValue = toolSearchSection.searchInputField.getAttribute("value");

        // Assert the input field value
        Assert.assertEquals(inputFieldValue, searchString);
    }
}
