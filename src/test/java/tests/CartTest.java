package tests;

import tests.BaseTest;
import pages.*;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    

    @Test
    public void validateThatUserAddProductsToCart() {
        // Test implementation
        homePage = new HomePage(getDriver());
        cartPage = new CartPage(getDriver());
        productListingPage = new ProductListingPage(getDriver());
        homePage.navigate();
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addProductsToCart();
        productListingPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatProductsAddedToCart();

    }
    @Test
    public void validateTheUserDeleteProductsFromCart() {        // Test implementation

        cartPage= new CartPage(getDriver());
        productListingPage= new ProductListingPage(getDriver());
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addProductsToCart();
        productListingPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.clearCart();
        cartPage.assertThatCartIsEmpty();

    }
    @Test
    public void validateThatUserAddProductsWhenLoggedIn() {
        // Test implementation
        homePage = new HomePage(getDriver());
        signupLoginPage = new SignUpLoginPage(getDriver());
        cartPage = new CartPage(getDriver());
        productListingPage = new ProductListingPage(getDriver());
        homePage.navigate();
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addProductsToCart();
        homePage.clickSignupLoginBtn();
        signupLoginPage.login("amrm@qa.team", "12345678");
        homePage.assertUserLoggedIn();
        cartPage.navigate();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatProductsAddedToCart();
        cartPage.clearCart();


    }
    @Test
    public void validateUserUpdateProductQuantityFromCart() {
        // Test implementation
        cartPage= new CartPage(getDriver());
        productListingPage= new ProductListingPage(getDriver());
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        //productListingPage.addProductToCart(1);
        productListingPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.clickQuantityBtn();

    }
    @Test
    public void validateThatQuantityIs1WhenAddingFromProductListingPage() {
        // Test implementation
        cartPage= new CartPage(getDriver());
        productListingPage= new ProductListingPage(getDriver());
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addBlueTopProductToCart();
        productListingPage.assertThatProductIsAddedToCart();
        productListingPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatQuantityis1();

    }

    @Test
    public void validateThatUserCanAddProductsToCartFromProductDetailsPage() {
        cartPage= new CartPage(getDriver());
        productListingPage= new ProductListingPage(getDriver());
        blueTopDetailsPage = new BlueTopDetailsPage(getDriver());
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.clickBlueTopView();
        blueTopDetailsPage.assertThatUserIsOnBlueTopDetailsPage();
        blueTopDetailsPage.assertThatProductDetailsAreDisplayed();
        blueTopDetailsPage.setQuantity(6);
        blueTopDetailsPage.addToCart();
        blueTopDetailsPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatBlueTopIsOnCart();


    }
}
