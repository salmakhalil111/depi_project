package tests;

import pages.*;
import org.testng.annotations.Test;

// Feature 3: Search products on /products page
public class ProductSearchTests extends BaseTest {
    ProductListingPage productListingPage;

    @Test
    public void validateUserCanSearchForExistingProduct() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.searchForProduct("dress");
        productListingPage.assertThatSearchResultsAreDisplayed();
    }

    @Test
    public void validateSearchWithAnotherKeyword() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.searchForProduct("top");
        productListingPage.assertThatSearchResultsAreDisplayed();
    }

    @Test
    public void validateSearchIsCaseInsensitive() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.searchForProduct("TOP");
        productListingPage.assertThatSearchResultsAreDisplayed();
    }
}
