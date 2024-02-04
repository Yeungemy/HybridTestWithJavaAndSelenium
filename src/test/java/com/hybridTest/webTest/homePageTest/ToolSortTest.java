package com.hybridTest.webTest.homePageTest;

import com.hybridTest.pageObjectOfModels.webUiTestPages.homePageTest.ToolSortSectionTest;
import com.hybridTest.webTest.BaseWebUiTest;
import org.testng.annotations.Test;

public class ToolSortTest extends BaseWebUiTest {
    @Test
    public void sortToolByNameInDescOrder() {
        ToolSortSectionTest toolSortSectionTest = new ToolSortSectionTest(driver);

        toolSortSectionTest.sortToolsByNameDescOrder();
    }
}
