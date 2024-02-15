package com.hybridTest.apiTest.Options;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/FindByStatus.feature"},
        glue = "com.hybridTest.apiTest.stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

