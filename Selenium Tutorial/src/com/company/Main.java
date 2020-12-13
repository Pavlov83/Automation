package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",("/Users/pav/Documents/SeleniumDrivers"));
        WebDriver driver;
        driver = new ChromeDriver();
        String baseUrl = "https://learn.letskodeit.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user_email")).sendKeys("Sending email");

    }
}
