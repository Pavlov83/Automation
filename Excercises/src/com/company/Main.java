package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/pav/Documents/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://letskodeit.teachable.com/p/practice";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector()).sendKeys("Selenium");

    }
}
