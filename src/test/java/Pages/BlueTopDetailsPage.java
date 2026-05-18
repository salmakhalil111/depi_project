package Pages;

import Tests.BaseTest;
import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BlueTopDetailsPage extends BaseTest {

    // Attributes
    final private String URL = "https://automationexercise.com/product_details/1";

    // Driver
    WebDriver driver;

    // Constructor
    public BlueTopDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By productName_Txt = By.xpath("//h2[text()=\"Blue Top\"]");
    private final By productPrice_Txt = By.xpath("//span[text()='Rs. 500']");
    private final By productImage_Img = By.xpath("//img[@src=\"/get_product_picture/1\"]");
    private final By quantity_TxtBox = By.id("quantity");
    private final By addToCart_Btn = By.xpath("//button[@class='btn btn-default cart']");
    private final By productDescription_Txt = By.xpath("//div[@class='product-details']//p");
    private final By productReviews_Txt = By.xpath("//a[@href='#reviews']");

    // Actions
    public void setQuantity(int quantity) {
        ElementActions.type(driver, quantity_TxtBox, String.valueOf(quantity));
    }

        public void addToCart() {
            ElementActions.click(driver, addToCart_Btn);
        }

    // Assertions
    public void assertThatUserIsOnBlueTopDetailsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName_Txt));
        Assert.assertTrue(driver.findElement(productName_Txt).isDisplayed());
        Assert.assertTrue(driver.findElement(productPrice_Txt).isDisplayed());
    }

    public void assertThatProductDetailsAreDisplayed() {
        Assert.assertTrue(driver.findElement(productImage_Img).isDisplayed());
        Assert.assertTrue(driver.findElement(productDescription_Txt).isDisplayed());
        Assert.assertTrue(driver.findElement(quantity_TxtBox).isDisplayed());
        Assert.assertTrue(driver.findElement(addToCart_Btn).isDisplayed());
    }

}
