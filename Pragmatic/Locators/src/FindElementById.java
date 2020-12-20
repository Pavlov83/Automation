import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindElementById {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver",
                "/Users/pav/Documents/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://amazon.com";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("glow-ingress-line2")).click();




    }
}
