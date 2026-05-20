package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductsPage;

// Feature 2: Product Details (single product page)
public class ProductDetailsTests extends BaseTestTwo {

    // TC01: Product details page opens after clicking "View Product"
    @Test(priority = 1)
    public void openProductDetailsPage() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        ProductDetailsPage details = products.openFirstProductDetails();
        Assert.assertTrue(driver.getCurrentUrl().contains("/product_details/"),
                "URL should contain /product_details/");
        Assert.assertTrue(details.isProductNameVisible(), "Product name should be visible");
    }

    // TC02: Product price is visible
    @Test(priority = 2)
    public void productPriceIsVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        ProductDetailsPage details = products.openFirstProductDetails();
        Assert.assertTrue(details.isProductPriceVisible(), "Product price should be visible");
    }

    // TC03: Product details show Category, Availability, Condition and Brand
    @Test(priority = 3)
    public void productInformationFieldsVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        ProductDetailsPage details = products.openFirstProductDetails();
        Assert.assertTrue(details.isCategoryVisible(),     "Category should be visible");
        Assert.assertTrue(details.isAvailabilityVisible(), "Availability should be visible");
        Assert.assertTrue(details.isConditionVisible(),    "Condition should be visible");
        Assert.assertTrue(details.isBrandVisible(),        "Brand should be visible");
    }

    // TC04: Default quantity is 1 and can be changed
    @Test(priority = 4)
    public void quantityFieldDefaultAndUpdate() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        ProductDetailsPage details = products.openFirstProductDetails();

        Assert.assertEquals(details.getQuantityValue(), "1", "Default quantity should be 1");

        details.setQuantity("3");
        Assert.assertEquals(details.getQuantityValue(), "3", "Quantity should update to 3");
    }

    // TC05: "Write Your Review" section visible after scroll
    @Test(priority = 5)
    public void writeYourReviewSectionVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        ProductDetailsPage details = products.openFirstProductDetails();
        Assert.assertTrue(details.isReviewSectionVisible(),
                "Write Your Review section should be visible");
    }
}
