package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomepageGuest {
    public static void main(String[] args) {
        //TC01 title of the homepage should be "Automation Exercise"
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        //TC2 Verify that the Navigation bar elements are visible successfully
        // Verify that the 'Signup / Login' button is visible (as guest user)
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/login']")).isDisplayed());
        //logo
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/products']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/contact_us']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/view_cart']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/test_cases']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/api_list']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='https://www.youtube.com/c/AutomationExercise']")).isDisplayed());
        //Category / Brands need to scroll down to see it !!
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("accordian"))).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/brands']")).isDisplayed());







        // Complete your findElement code here
        driver.quit();

    }
}
