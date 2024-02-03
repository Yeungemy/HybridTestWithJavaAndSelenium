package com.hybridTest.pageObjectsTest.homePageTest;

import com.hybridTest.pageObjectsTest.BasePageTest;
import com.hybridTest.utilsTest.WaitUtilsTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolSortSectionTest extends BasePageTest {
    protected final String NAME_DESC_SORT_OPTION = "name,desc";

    public ToolSortSectionTest(WebDriver driver){
        super(driver);
    }

    //locators
    @FindBy(css = "[data-test=\"sort\"]")
    public WebElement sortDropdownField;

    @FindBy(css = "[value=\"name,desc\"]")
    public WebElement nameDescSortOption;

    public void sortToolsByNameDescOrder(){
        WaitUtilsTest.waitAndClick(sortDropdownField);
        WaitUtilsTest.waitAndClick(nameDescSortOption);
        WaitUtilsTest.waitForContentInInputField(sortDropdownField, NAME_DESC_SORT_OPTION);
    }
}
