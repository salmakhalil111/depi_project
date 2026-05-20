package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class ProductBrowsingTests extends BaseTest {
    HomePage homePage;
    ProductListingPage productListingPage;

    @Test
    public void validateThatUserIsOnProductListingPage() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
    }

    @Test
    public void validateNavigationFromHomeToProducts() {
        homePage = new HomePage(driver);
        productListingPage = new ProductListingPage(driver);
        homePage.navigate();
        homePage.assertThatUserIsOnHomePage();
        homePage.clickProductsLink();
        productListingPage.assertThatUserIsOnProductListingPage();
    }

    @Test
    public void validateThatProductsListIsDisplayed() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.assertThatProductsListIsDisplayed();
    }

    @Test
    public void validateThatCategoryAndBrandSidebarsAreVisible() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.assertThatSidebarsAreVisible();
    }
}
