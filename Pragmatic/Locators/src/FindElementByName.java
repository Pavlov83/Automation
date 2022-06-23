import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindElementByName {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",
                "/Users/pav/Documents/SeleniumDrivers/chromedriver");
        String baseUrl = "https://amazon.com";
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("url")).click();
    }
}
