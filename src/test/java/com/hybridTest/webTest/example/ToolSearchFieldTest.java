package com.hybridTest.webTest.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolSearchFieldTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up chrome driver
        WebDriverManager.chromedriver().setup();

        // Create an instance of chrome driver
        driver = new ChromeDriver();

        // Open the website
        driver.get("https://practicesoftwaretesting.com/#/");

        // Maximize the window
        driver.manage().window().maximize();

        // Dynamically wait for the body to be present
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }
    @Test
    public void launchGoogle() {
        String searchString = "Combination Pliers";
        WebElement inputField = driver.findElement(By.cssSelector("[data-test='search-query']"));
        inputField.sendKeys(searchString);

        String inputFieldValue = inputField.getAttribute("value");

        Assert.assertEquals(inputFieldValue, searchString);
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}