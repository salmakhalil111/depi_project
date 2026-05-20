package Pages;

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
    private final By searchSubmit_Btn = By.id("submit_search");
    private final By searchedProductsTitle_txt = By.xpath("//h2[normalize-space()='Searched Products']");
    private final By productCard = By.xpath("//div[@class='features_items']//div[contains(@class,'product-image-wrapper')]");
    private final By categorySidebar = By.xpath("//div[@id='accordian']");
    private final By brandsSidebar = By.xpath("//div[@class='brands_products']");
    private final By womenCategory_link = By.xpath("//a[@href='#Women']");
    private final By womenDressSub_link = By.xpath("//a[@href='/category_products/1']");
    private final By menCategory_link = By.xpath("//a[@href='#Men']");
    private final By menTshirtsSub_link = By.xpath("//a[@href='/category_products/3']");
    private final By poloBrand_link = By.xpath("//a[@href='/brand_products/Polo']");
    private final By categoryHeader_txt = By.xpath("//h2[@class='title text-center']");
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

    public void searchForProduct(String text) {
        ElementActions.type(driver, search_TxtBox, text);
        ElementActions.click(driver, searchSubmit_Btn);
    }

    public void clickWomenCategory() {
        ElementActions.click(driver, womenCategory_link);
    }

    public void clickWomenDressSubCategory() {
        ElementActions.click(driver, womenDressSub_link);
    }

    public void clickMenCategory() {
        ElementActions.click(driver, menCategory_link);
    }

    public void clickMenTshirtsSubCategory() {
        ElementActions.click(driver, menTshirtsSub_link);
    }

    public void clickPoloBrand() {
        ElementActions.click(driver, poloBrand_link);
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

    public void assertThatProductsListIsDisplayed() {
        int count = driver.findElements(productCard).size();
        Assert.assertTrue(count > 0, "Products list should not be empty");
    }

    public void assertThatSidebarsAreVisible() {
        Assert.assertTrue(driver.findElement(categorySidebar).isDisplayed(), "Category sidebar not visible");
        Assert.assertTrue(driver.findElement(brandsSidebar).isDisplayed(),   "Brands sidebar not visible");
    }

    public void assertThatSearchResultsAreDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle_txt));
        Assert.assertTrue(driver.findElement(searchedProductsTitle_txt).isDisplayed(),
                "'Searched Products' header should be visible");
        Assert.assertTrue(driver.findElements(productCard).size() > 0,
                "At least one product should be returned by search");
    }

    public void assertThatCategoryPageIsDisplayed(String expectedHeader) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHeader_txt));
        Assert.assertTrue(
                driver.findElement(categoryHeader_txt).getText().toUpperCase().contains(expectedHeader.toUpperCase()),
                "Expected category header to contain: " + expectedHeader);
        Assert.assertTrue(driver.findElements(productCard).size() > 0,
                "Category should contain at least one product");
    }

    public void assertThatBrandPageIsDisplayed(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/brand_products/" + brand));
        Assert.assertTrue(driver.getCurrentUrl().contains("/brand_products/" + brand),
                "URL should contain /brand_products/" + brand);
        Assert.assertTrue(driver.findElements(productCard).size() > 0,
                "Brand page should contain at least one product");
    }
}

