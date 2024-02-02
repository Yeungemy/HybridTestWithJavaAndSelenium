package com.hybridTest.webTest.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolSortTest {

    @Test
    public void sortToolByNameInDescOrder() {
        // set up chrome driver
        WebDriverManager.chromedriver().setup();

        // create an instance of chrome driver
        WebDriver driver = new ChromeDriver();

        // open the website
        driver.get("https://practicesoftwaretesting.com/#/");

        // get element of sort field
        WebElement sortInputField = driver.findElement(By.cssSelector("[data-test=\"sort\"]"));

        // click the field to open the dropdown list
        sortInputField.click();

        // get the option of DESC name
        WebElement descNameOption = driver.findElement(By.cssSelector("[value=\"name,desc\"]"));

        // Wait for the option to be clickable
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(descNameOption));

        // select the option
        descNameOption.click();

        // wait for the option to be selected
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(
                sortInputField, "value", "name,desc"));

        // verify the option has been selected
        String optionName = sortInputField.getAttribute("value");
        Assert.assertEquals(optionName, "name,desc");

        // quit the driver
        driver.quit();
    }
}
