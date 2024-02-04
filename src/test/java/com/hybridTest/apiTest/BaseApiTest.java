package com.hybridTest.apiTest;

import com.hybridTest.config.ConfigReaderTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import listeners.ApiTestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ApiTestListener.class)
public class BaseApiTest {
    protected RequestSpecification requestSpec;
    protected final String BASE_URI = "api_test_uri";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReaderTest.getTestPlatformUrl(BASE_URI);
        requestSpec = new RequestSpecBuilder().build();
    }

    @AfterClass
    public void tearDown() {
        RestAssured.reset();
    }
}

