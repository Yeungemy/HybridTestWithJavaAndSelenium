package com.hybridTest.apiTest.stepDefinitions.pet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

@io.qameta.allure.Feature("Pet Store Operations")
public class FindByStatusStepDef {
    private Response response;

    @Given("there are pets {string} in the store")
    @io.qameta.allure.Story("Verify finding pets by status")
    public void givenThereArePetsWithStatusInTheStore(String status) {
        System.out.println("Status provided: " + status);
    }

    @When("the user requests to find pets {string} in the store using a GET request")
    @io.qameta.allure.Story("Verify finding pets by status")
    public void whenTheUserRequestsToFindPetsByStatusUsingGetRequest(String status) {
        response = RestAssured.given()
                .queryParam("status", status)
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
    }

    @Then("the response status code should be {int}")
    @io.qameta.allure.Story("Verify finding pets by status")
    public void verifyResponseStatusCodeShouldBe200(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Response status code is not as expected");
    }

    @And("the response body should contain pets with status {string}")
    @io.qameta.allure.Story("Verify finding pets by status")
    public void verifyResponseBodyShouldContainPetsWithStatus(String status) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"status\":\"" + status + "\""));
    }

    @Given("an invalid {string} is provided")
    @io.qameta.allure.Story("Verify finding pets by status with invalid input")
    public void anInvalidStatusIsProvided(String invalidStatus) {
        System.out.println("Invalid status provided: " + invalidStatus);
    }

    @When("the user requests to find pets {string} using a GET request")
    @io.qameta.allure.Story("Verify finding pets by status with invalid input")
    public void whenTheUserRequestsToFindPetsUsingGetRequest(String status) {
        response = RestAssured.given()
                .queryParam("status", status)
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
    }

    @Then("the response status code should be 200 for invalid status")
    @io.qameta.allure.Story("Verify finding pets by status with invalid input")
    public void verifyResponseStatusCodeShouldBe200ForInvalidStatus() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @And("the response body should be empty")
    @io.qameta.allure.Story("Verify finding pets by status with invalid input")
    public void verifyResponseBodyShouldBeEmpty() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody, "[]");
    }
}
