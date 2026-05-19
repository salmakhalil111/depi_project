package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteOrderFlow {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and navigate to the homepage
         driver = new ChromeDriver();
         driver.get("https://automationexercise.com/");
        // Implement login steps here
        // For example:
        // driver.findElement(By.cssSelector("a[href='/login']")).click();
        // driver.findElement(By.cssSelector("input[name='email']")).sendKeys("your_email
        // driver.findElement(By.cssSelector("input[name='password']")).sendKeys("your_password");
        // driver.findElement(By.cssSelector("button[type='submit']")).click();


    }
    public void login() {
        // Implement login steps here
        driver.findElement(By.cssSelector("a='href='/login']")).click();
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("salma111@user.com");
        driver.findElement(By.name("password")).sendKeys("@u8@zMPxV@kkfeS");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver after each test
        driver.quit();
    }

    @Test
    public void testCompleteOrderFlow() {
        // Implement the complete order flow test steps here
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        Assert.assertEquals(driver.getCurrentUrl() , "https://automationexercise.com/products");
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.cssSelector("img[src='/get_product_picture/1']"))) .perform();
         driver.findElement(By.cssSelector("a[dta-product-id='1'][0]")).click();
         actions.scrollToElement(driver.findElement(By.cssSelector("a[href='/view_cart']"))).perform();
         driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        // 1. Add items to the cart
        // 2. Proceed to checkout
        // 3. Fill in shipping and payment details
        // 4. Confirm the order
        // 5. Verify order confirmation

        // Note: The actual implementation will depend on the structure of the website and the elements you need to interact with.
    }


}
