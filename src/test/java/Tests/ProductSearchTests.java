package Tests;

import Base.BaseTestTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

// Feature 3: Search products on /products page
public class ProductSearchTests extends BaseTestTwo {

    // TC01: Search bar is visible on products page (guest)
    @Test(priority = 1)
    public void searchBarVisibleForGuest() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        // searching for empty word just to ensure the input field is present
        Assert.assertTrue(driver.findElement(org.openqa.selenium.By.id("search_product")).isDisplayed(),
                "Search input should be visible");
    }

    // TC02: Search for a valid keyword returns the "Searched Products" header
    @Test(priority = 2)
    public void searchValidKeywordShowsHeader() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.searchFor("dress");
        Assert.assertTrue(products.isSearchedHeaderVisible(),
                "Searched Products header should appear");
    }

    // TC03: Search results match the keyword (at least one product)
    @Test(priority = 3)
    public void searchResultsContainKeyword() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.searchFor("dress");
        Assert.assertTrue(products.atLeastOneResultContains("dress"),
                "At least one result should contain the keyword 'dress'");
    }

    // TC04: Search with another keyword (case-insensitive)
    @Test(priority = 4)
    public void searchAnotherKeyword() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.searchFor("Top");
        Assert.assertTrue(products.isSearchedHeaderVisible(),
                "Searched Products header should appear for 'Top'");
        Assert.assertTrue(products.getProductCount() > 0,
                "Should return at least one product for 'Top'");
    }

    // TC05: Search for a non-existent product returns zero results
    @Test(priority = 5)
    public void searchNonExistentProduct() {
        ProductsPage products = new ProductsPage(driver);
        products.open();
        products.searchFor("xyzabc123nothing");
        int count = products.getProductCount();
        System.out.println("Result count for invalid keyword: " + count);
        Assert.assertEquals(count, 0,
                "No products should be returned for a non-existent keyword");
    }
}
