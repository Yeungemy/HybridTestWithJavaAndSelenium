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

public class ToolSortTest {

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
    public void sortToolByNameInDescOrder() {
        // Get element of sort field
        WebElement sortInputField = driver.findElement(By.cssSelector("[data-test=\"sort\"]"));

        // Click the field to open the dropdown list
        sortInputField.click();

        // Get the option of DESC name
        WebElement descNameOption = driver.findElement(By.cssSelector("[value=\"name,desc\"]"));

        // Wait for the option to be clickable
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(descNameOption));

        // Select the option
        descNameOption.click();

        // Wait for the option to be selected
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(
                sortInputField, "value", "name,desc"));

        // Verify the option has been selected
        String optionName = sortInputField.getAttribute("value");
        Assert.assertEquals(optionName, "name,desc");
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
