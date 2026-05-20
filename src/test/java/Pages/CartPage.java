package Pages;

import utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {

    // Att.
    private final String URL = "https://automationexercise.com/view_cart";

    // Driver
    WebDriver driver;
    // const.

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By pageName_txt = By.xpath("//li[@class=\"active\"]");
    private final By deleteProduct_btn = By.xpath("//a[@class=\"cart_quantity_delete\"]");
    private final By proceedToCheckout_btn = By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private final By cartEmpty_Txt = By.xpath("//b[text()='Cart is empty!']");
    private final By menTshirt_txt = By.xpath("//*[@id=\"product-2\"]/td[2]/p");
    private final By blueTop_txt = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");
    private final By sleevelessDress_txt = By.xpath("//*[@id=\"product-3\"]/td[2]/h4/a");
    private final By menTshirtPrice = By.xpath("//*[@id=\"product-2\"]/td[3]/p");
    private final By bluetopPrice = By.xpath("//*[@id=\"product-1\"]/td[3]/p");
    private final By clear_btn = By.className("cart_quantity_delete");
    private final By sleevelessDressPrice = By.xpath("//*[@id=\"product-3\"]/td[3]/p");
    private final By blueTopQuantity_txt = By.xpath("//*[@id=\"product-1\"]/td/button");

    //Actions
    public void navigate() {
        driver.get(URL);
    }


    public void clearCart() { // 1 usage new *

        List<WebElement> clear_buttons = driver.findElements(deleteProduct_btn);
        for (WebElement button : clear_buttons) {
            button.click();
        }
    }

    public void deleteProductFromCart() {
        ElementActions.click(driver, deleteProduct_btn);
    }

    public void clickQuantityBtn() {

        ElementActions.type(driver, blueTopQuantity_txt, "3");
    }

    // Assertions
    public void assertThatUserIsOnCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        Assert.assertTrue(driver.findElement(pageName_txt).isDisplayed());
        Assert.assertEquals(driver.findElement(pageName_txt).getText(), "Shopping Cart");
    }

    public void assertThatCartIsEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartEmpty_Txt));
        Assert.assertTrue(driver.findElement(cartEmpty_Txt).isDisplayed());
        Assert.assertEquals(driver.findElement(cartEmpty_Txt).getText(), "Cart is empty!");
    }

    public void assertThatProductsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Assert Blue Top product name is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(blueTop_txt));
        Assert.assertTrue(driver.findElement(blueTop_txt).isDisplayed(), "Blue Top product name is not displayed");
        Assert.assertEquals(driver.findElement(bluetopPrice).getText(), "Rs. 500");

        // Assert Men Tshirt product name is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(menTshirt_txt));
        Assert.assertTrue(driver.findElement(menTshirt_txt).isDisplayed(), "Men Tshirt product name is not displayed");
        Assert.assertEquals(driver.findElement(menTshirtPrice).getText(), "Rs. 400");

        // Assert Sleeveless Dress product name is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(sleevelessDress_txt));
        Assert.assertTrue(driver.findElement(sleevelessDress_txt).isDisplayed(), "Sleeveless Dress product name is not displayed");
        Assert.assertEquals(driver.findElement(sleevelessDressPrice).getText(), "Rs. 1000");

    }

    public void assertThatQuantityis1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(blueTopQuantity_txt));
        Assert.assertTrue(driver.findElement(blueTopQuantity_txt).isDisplayed(), "Quantity button is not displayed");
        Assert.assertEquals(driver.findElement(blueTopQuantity_txt).getText(), "1", "Quantity is not 1 by default");
    }

    public void assertThatBlueTopIsOnCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(blueTop_txt));
        Assert.assertTrue(driver.findElement(blueTop_txt).isDisplayed(), "Blue Top product name is not displayed");
    }
}


