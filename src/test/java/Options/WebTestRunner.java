package Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/featuresOfWebTest/ToolSearchFieldTest.feature",
        glue = "com.hybridTest.webTest.stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports"
        }
)
public class WebTestRunner extends AbstractTestNGCucumberTests {
}

