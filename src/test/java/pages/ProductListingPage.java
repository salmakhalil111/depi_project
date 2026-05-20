package pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductListingPage {

    // Variables

    final private String URL = "https://automationexercise.com/products";

    // Driver
    WebDriver driver;

    // Constructor
    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By pageTitle_txt = By.xpath("//h2[@class=\"title text-center\"]");
    private final By search_TxtBox = By.id("search_product");
    private final By blueTop_img = By.xpath("//img[@src='/get_product_picture/1']");
    private final By addToCartBlueTop_Btn = By.xpath("//a[@data-product-id='1']");
    private final By menTshirt_img = By.xpath("//img[@src='/get_product_picture/2']");
    private final By addToCartMenTshirt_Btn = By.xpath("//a[@data-product-id=2]");
    private final By sleevlessDress_img = By.xpath("//img[@src='/get_product_picture/3']");
    private final By addToCartSleevelessDress_Btn = By.xpath("//a[@data-product-id=3]");
    private final By bluetopDetails_btn = By.xpath("//a[@href='/product_details/1']");
    private final By menTshirtDetails_btn = By.xpath("//a[@href='/product_details/2']");
    private final By addedToCartMessage_Txt = By.xpath("//h4[text()='Added!']");
    private final By viewCart_Link = By.xpath("//u[text()='View Cart']");
    private final By continueShopping_Btn = By.xpath("//button[text()='Continue Shopping']");

    //Actions
    public void navigate() {
        driver.get(URL);
    }

    public void addProductsToCart() {
        ElementActions.click(driver, addToCartBlueTop_Btn);
        ElementActions.click(driver, continueShopping_Btn);
        ElementActions.click(driver, addToCartMenTshirt_Btn);
        ElementActions.click(driver, continueShopping_Btn);
        ElementActions.click(driver, addToCartSleevelessDress_Btn);

    }

    public void clickBlueTopView() {
        ElementActions.click(driver, bluetopDetails_btn);
    }

    public void clickViewCart() {
        ElementActions.click(driver, viewCart_Link);
    }

    public void clickContinueShopping() {
        ElementActions.click(driver, continueShopping_Btn);
    }

    public void addBlueTopProductToCart() {
        ElementActions.click(driver, addToCartBlueTop_Btn);
    }

    public void hoverOverBlueTop() {
        ElementActions.hoverOverElement(driver, addToCartBlueTop_Btn);
    }

    // Assertions
    public void assertThatUserIsOnProductListingPage() {
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        Assert.assertTrue(driver.findElement(pageTitle_txt).isDisplayed());
        Assert.assertTrue(driver.findElement(search_TxtBox).isDisplayed());
    }

    public void assertThatProductIsAddedToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartMessage_Txt));
        Assert.assertTrue(driver.findElement(addedToCartMessage_Txt).isDisplayed());
        Assert.assertEquals(driver.findElement(addedToCartMessage_Txt).getText(), "Added!");
    }


}

