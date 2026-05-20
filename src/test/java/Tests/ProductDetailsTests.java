package Tests;

import Pages.*;
import org.testng.annotations.Test;

public class ProductDetailsTests extends BaseTest {
    ProductListingPage productListingPage;
    BlueTopDetailsPage blueTopDetailsPage;
    CartPage cartPage;

    @Test
    public void validateUserCanOpenProductDetailsPage() {
        productListingPage = new ProductListingPage(driver);
        blueTopDetailsPage = new BlueTopDetailsPage(driver);
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.clickBlueTopView();
        blueTopDetailsPage.assertThatUserIsOnBlueTopDetailsPage();
    }

    @Test
    public void validateProductDetailsAreDisplayed() {
        productListingPage = new ProductListingPage(driver);
        blueTopDetailsPage = new BlueTopDetailsPage(driver);
        productListingPage.navigate();
        productListingPage.clickBlueTopView();
        blueTopDetailsPage.assertThatUserIsOnBlueTopDetailsPage();
        blueTopDetailsPage.assertThatProductDetailsAreDisplayed();
        blueTopDetailsPage.assertThatProductPriceIsVisible();
    }

    @Test
    public void validateUserCanChangeQuantity() {
        productListingPage = new ProductListingPage(driver);
        blueTopDetailsPage = new BlueTopDetailsPage(driver);
        productListingPage.navigate();
        productListingPage.clickBlueTopView();
        blueTopDetailsPage.assertThatUserIsOnBlueTopDetailsPage();
        blueTopDetailsPage.setQuantity(5);
        blueTopDetailsPage.assertThatQuantityIs(5);
    }

    @Test
    public void validateUserCanAddProductFromDetailsPage() {
        productListingPage = new ProductListingPage(driver);
        blueTopDetailsPage = new BlueTopDetailsPage(driver);
        cartPage = new CartPage(driver);
        productListingPage.navigate();
        productListingPage.clickBlueTopView();
        blueTopDetailsPage.assertThatUserIsOnBlueTopDetailsPage();
        blueTopDetailsPage.setQuantity(2);
        blueTopDetailsPage.addToCart();
        blueTopDetailsPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatBlueTopIsOnCart();
    }
}
