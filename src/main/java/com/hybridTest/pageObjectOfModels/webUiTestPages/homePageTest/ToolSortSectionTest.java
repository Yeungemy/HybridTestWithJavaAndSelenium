package com.hybridTest.pageObjectOfModels.webUiTestPages.homePageTest;

import com.hybridTest.pageObjectOfModels.webUiTestPages.BasePageTest;
import com.hybridTest.utils.WaitUtilsE2eTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolSortSectionTest extends BasePageTest {
    protected final String NAME_DESC_SORT_OPTION = "name,desc";
    //locators
    @FindBy(css = "[data-test=\"sort\"]")
    public WebElement sortDropdownField;
    @FindBy(css = "[value=\"name,desc\"]")
    public WebElement nameDescSortOption;

    public ToolSortSectionTest(WebDriver driver) {
        super(driver);
    }

    public void sortToolsByNameDescOrder() {
        WaitUtilsE2eTest.waitAndClick(sortDropdownField);
        WaitUtilsE2eTest.waitAndClick(nameDescSortOption);
        WaitUtilsE2eTest.waitForTextPresentedInInputField(sortDropdownField, NAME_DESC_SORT_OPTION);
    }
}
