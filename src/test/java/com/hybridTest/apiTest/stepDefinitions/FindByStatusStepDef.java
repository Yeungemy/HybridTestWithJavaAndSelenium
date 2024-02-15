package com.hybridTest.apiTest.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class FindByStatusStepDef {
    private Response response;

    @Given("there are pets {string} in the store")
    public void givenThereArePetsWithStatusInTheStore(String status) {
        System.out.println("Status provided: " + status);
    }

    @When("the user requests to find pets {string} in the store using a GET request")
    public void whenTheUserRequestsToFindPetsByStatusUsingGetRequest(String status) {
        response = RestAssured.given()
                .queryParam("status", status)
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCodeShouldBe200(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Response status code is not as expected");
    }

    @And("the response body should contain pets with status {string}")
    public void verifyResponseBodyShouldContainPetsWithStatus(String status) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"status\":\"" + status + "\""));
    }

    @Given("an invalid {string} is provided")
    public void anInvalidStatusIsProvided(String invalidStatus) {
        System.out.println("Invalid status provided: " + invalidStatus);
    }

    @When("the user requests to find pets {string} using a GET request")
    public void whenTheUserRequestsToFindPetsUsingGetRequest(String status) {
        response = RestAssured.given()
                .queryParam("status", status)
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
    }

    @Then("the response status code should be 200 for invalid status")
    public void verifyResponseStatusCodeShouldBe200ForInvalidStatus() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @And("the response body should be empty")
    public void verifyResponseBodyShouldBeEmpty() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody, "[]");
    }
}
