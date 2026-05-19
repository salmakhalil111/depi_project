package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Testsss {

    @Test
    public void test1()
    {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://www.flighthub.com/travel-packages");
        driver.findElement(By.xpath("//div[@class='sunshine-header-nav fh']//div[contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Email']")).click();
    }
}
