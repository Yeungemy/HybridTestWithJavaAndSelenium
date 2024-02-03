package com.hybridTest.webUITest.e2eTest.homePageTest;

import com.hybridTest.webUITest.pageObjectsTest.homePageTest.ToolSortSectionTest;
import com.hybridTest.webUITest.e2eTest.BaseTest;
import org.testng.annotations.Test;

public class ToolSortTest extends BaseTest {
    @Test
    public void sortToolByNameInDescOrder() {
        ToolSortSectionTest toolSortSectionTest = new ToolSortSectionTest(driver);

        toolSortSectionTest.sortToolsByNameDescOrder();
    }
}
