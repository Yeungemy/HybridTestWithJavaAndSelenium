package com.hybridTest.smallProjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Arrays;

public class ArrayCucumberTest {

    private int[] numbers;
    private int result;

    @Given("an array with duplicates {string}")
    public void an_array_with_duplicates(String duplicates) {
        // Convert the string of duplicates to an array of integers
        numbers = Arrays.stream(duplicates.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @Then("remove duplicates and get the total number of elements")
    public void remove_duplicates_and_get_the_total_number_of_elements() {
        Arrays.sort(numbers);
        result = removeDuplicates(numbers);
    }

    @Then("the total number of elements should be {int}")
    public void the_total_number_of_elements_should_be(int expected) {
        // Print the results individually or in any desired format
        System.out.println("Total number of elements is: " + result);
        Assert.assertEquals(result, expected);
    }

    private int removeDuplicates(int[] nums) {
        int k = 0;

        for (int num : nums) {
            if (k == 0 || num != nums[k - 1]) {
                nums[k++] = num;
            }
        }
        return k;
    }
}
