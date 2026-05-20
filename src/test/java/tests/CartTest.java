package tests;

import pages.*;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    

    @Test
    public void validateThatUserAddProductsToCart() {
        // Test implementation
        MainHomePage homePage = new MainHomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        ProductListingPage productListingPage = new ProductListingPage(getDriver());
        homePage.open();
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addProductsToCart();
        productListingPage.clickViewCart();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatProductsAddedToCart();

    }
    @Test
    public void validateTheUserDeleteProductsFromCart() {        // Test implementation

        CartPage cartPage= new CartPage(getDriver());
        ProductListingPage productListingPage= new ProductListingPage(getDriver());
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
        MainHomePage homePage = new MainHomePage(getDriver());
        SignUpLoginPage signupLoginPage = new SignUpLoginPage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        ProductListingPage productListingPage = new ProductListingPage(getDriver());
        homePage.open();
        productListingPage.navigate();
        productListingPage.assertThatUserIsOnProductListingPage();
        productListingPage.addProductsToCart();
        homePage.clickSignupLoginBtn();
        signupLoginPage.login("amrm@qa.team", "12345678");
        cartPage.navigate();
        cartPage.assertThatUserIsOnCartPage();
        cartPage.assertThatProductsAddedToCart();
        cartPage.clearCart();


    }
    @Test
    public void validateUserUpdateProductQuantityFromCart() {
        // Test implementation
        CartPage cartPage= new CartPage(getDriver());
        ProductListingPage productListingPage= new ProductListingPage(getDriver());
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
        CartPage cartPage= new CartPage(getDriver());
        ProductListingPage productListingPage= new ProductListingPage(getDriver());
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
        CartPage cartPage= new CartPage(getDriver());
        ProductListingPage productListingPage= new ProductListingPage(getDriver());
        BlueTopDetailsPage blueTopDetailsPage = new BlueTopDetailsPage(getDriver());
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
