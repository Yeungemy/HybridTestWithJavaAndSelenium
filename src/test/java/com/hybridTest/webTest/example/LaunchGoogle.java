package com.hybridTest.webTest.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchGoogle {
    @Test
    public void launchGoogle() {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create an instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Close the browser
        driver.quit();
    }
}