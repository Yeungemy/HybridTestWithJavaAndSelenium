package Options;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/featuresOfApiTest",
        glue = "com.hybridTest.apiTest.stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
}
