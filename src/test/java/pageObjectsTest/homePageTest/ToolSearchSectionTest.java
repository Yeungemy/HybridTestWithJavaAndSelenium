package pageObjectsTest.homePageTest;

import pageObjectsTest.BasePageTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolSearchSectionTest extends BasePageTest {
    // List all locators
    @FindBy(css = "[data-test=\"search-query\"]")
    public WebElement searchInputField;

    public ToolSearchSectionTest(WebDriver driver) {
        super(driver);
    }
}
