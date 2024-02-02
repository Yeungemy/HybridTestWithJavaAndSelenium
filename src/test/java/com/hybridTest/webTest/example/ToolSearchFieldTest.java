package com.hybridTest.webTest.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolSearchFieldTest {
    @Test
    public void launchGoogle() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://practicesoftwaretesting.com/#/");

        String searchString = "Combination Pliers";
        WebElement inputField = driver.findElement(By.cssSelector("[data-test='search-query']"));
        inputField.sendKeys(searchString);

        String inputFieldValue = inputField.getAttribute("value");

        Assert.assertEquals(inputFieldValue, searchString);

        // Close the browser
        driver.quit();
    }
}