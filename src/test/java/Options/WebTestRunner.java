package Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/featuresOfWebTest",
        glue = {
                "com.hybridTest.webTest.stepDefinitions.hooks",
                "com.hybridTest.webTest.stepDefinitions"
                },
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "listeners.WebCucumberTestListener"
                }
)
public class WebTestRunner extends AbstractTestNGCucumberTests {
}
