package tests;

import base.BaseTestTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

// Feature 1: Product Browsing (Guest user)
public class ProductBrowsingTests extends BaseTestTwo {

    // TC01: Go to Products page from home navbar
    @Test(priority = 1)
    public void navigateToProductsPageFromNavbar() {
        HomePage home = new HomePage(driver);
        home.open();
        ProductsPage products = home.goToProducts();
        Assert.assertTrue(products.isAllProductsHeaderVisible(), "All Products header should be visible");
    }

    // TC02: Products page URL should be correct
    @Test(priority = 2)
    public void productsPageUrlIsCorrect() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"),
                "URL should contain /products");
    }

    // TC03: At least one product card is shown
    @Test(priority = 3)
    public void productsListIsNotEmpty() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        int count = products.getProductCount();
        System.out.println("Number of products found: " + count);
        Assert.assertTrue(count > 0, "Should display at least one product");
    }

    // TC04: Each product should have a name and a price
    @Test(priority = 4)
    public void productsHaveNameAndPrice() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        int names  = products.getProductNames().size();
        int prices = products.getProductPrices().size();
        Assert.assertEquals(names, prices, "Each product should have both name and price");
        Assert.assertTrue(names > 0, "There should be at least one product");
    }

    // TC05: Category sidebar and Brands sidebar are visible
    @Test(priority = 5)
    public void categoryAndBrandSidebarVisible() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        Assert.assertTrue(products.isCategorySidebarVisible(), "Category sidebar should be visible");
        Assert.assertTrue(products.isBrandsSidebarVisible(),   "Brands sidebar should be visible");
    }
}
