package Options;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/featuresOfApiTest/FindByStatus.feature",
        glue = "com.hybridTest.apiTest.stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports"
        }
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
}

