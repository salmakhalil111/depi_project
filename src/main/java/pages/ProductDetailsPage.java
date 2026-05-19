package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// ProductDetailsPage: the /product_details/{id} page (one specific product)
public class ProductDetailsPage extends BasePage {

    // ---- Locators ----
    By productName    = By.cssSelector(".product-information h2");
    By productPrice   = By.cssSelector(".product-information span span");
    By category       = By.xpath("//div[@class='product-information']/p[1]");   // Category: ...
    By availability   = By.xpath("//div[@class='product-information']/p[2]");   // Availability: ...
    By condition      = By.xpath("//div[@class='product-information']/p[3]");   // Condition: ...
    By brand          = By.xpath("//div[@class='product-information']/p[4]");   // Brand: ...
    By quantityInput  = By.id("quantity");
    By addToCartBtn   = By.cssSelector("button.cart");
    By reviewSection  = By.xpath("//a[@href='#reviews']");
    By writeYourReview = By.xpath("//*[contains(text(),'Write Your Review')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible()  { return isDisplayed(productName); }
    public boolean isProductPriceVisible() { return isDisplayed(productPrice); }
    public boolean isCategoryVisible()     { return isDisplayed(category); }
    public boolean isAvailabilityVisible() { return isDisplayed(availability); }
    public boolean isConditionVisible()    { return isDisplayed(condition); }
    public boolean isBrandVisible()        { return isDisplayed(brand); }
    public boolean isQuantityVisible()     { return isDisplayed(quantityInput); }
    public boolean isAddToCartVisible()    { return isDisplayed(addToCartBtn); }
    public boolean isReviewSectionVisible() {
        scrollTo(writeYourReview);
        return isDisplayed(writeYourReview);
    }

    public String getProductName()  { return getText(productName); }
    public String getProductPrice() { return getText(productPrice); }

    public String getQuantityValue() {
        return findElement(quantityInput).getAttribute("value");
    }

    // change the quantity field
    public void setQuantity(String value) {
        type(quantityInput, value);
    }
}
