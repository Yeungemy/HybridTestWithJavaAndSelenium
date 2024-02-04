package com.hybridTest.webTest.homePageTest;

import com.hybridTest.pageObjectOfModels.webUiTestPages.homePageTest.ToolSearchSectionTest;
import com.hybridTest.utils.ActionUtilsE2eTest;
import com.hybridTest.webTest.BaseWebUiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolSearchFieldTest extends BaseWebUiTest {

    @Test
    public void verifyToolSearchField() {
        ToolSearchSectionTest toolSearchSection = new ToolSearchSectionTest(driver);

        String searchString = "***Combination Pliers1";
        ActionUtilsE2eTest.fillInputField(toolSearchSection.searchInputField, searchString);

        String inputFieldValue = toolSearchSection.searchInputField.getAttribute("value");

        // Assert the input field value
        Assert.assertEquals(inputFieldValue, searchString);
    }
}
