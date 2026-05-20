package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class ProductFilterTests extends BaseTest {
    ProductListingPage productListingPage;

    @Test
    public void validateThatCategoryAndBrandSidebarsAreVisible() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.assertThatSidebarsAreVisible();
    }

    @Test
    public void validateUserCanFilterByWomenDressCategory() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.clickWomenCategory();
        productListingPage.clickWomenDressSubCategory();
        productListingPage.assertThatCategoryPageIsDisplayed("Women - Dress Products");
    }

    @Test
    public void validateUserCanFilterByMenTshirtsCategory() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.clickMenCategory();
        productListingPage.clickMenTshirtsSubCategory();
        productListingPage.assertThatCategoryPageIsDisplayed("Men - Tshirts Products");
    }

    @Test
    public void validateUserCanFilterByPoloBrand() {
        productListingPage = new ProductListingPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.clickPoloBrand();
        productListingPage.assertThatBrandPageIsDisplayed("Polo");
    }
}
