package tests;

import pages.*;
import org.testng.annotations.Test;

// Feature 5: Header navigation (Guest vs Logged-in user)
public class HeaderNavigationTests extends BaseTest {
    HomePage homePage;
    SignUpLoginPage signupLoginPage;
    ProductListingPage productListingPage;
    CartPage cartPage;

    @Test
    public void validateThatUserIsOnHomePage() {
        homePage = new HomePage(driver);
        homePage.navigate();
        homePage.assertThatUserIsOnHomePage();
    }

    @Test
    public void validateAllNavbarLinksAreVisibleForGuest() {
        homePage = new HomePage(driver);
        homePage.navigate();
        homePage.assertThatUserIsOnHomePage();
        homePage.assertThatNavbarLinksAreVisibleForGuest();
        homePage.assertThatSignupLoginLinkIsVisible();
    }

    @Test
    public void validateUserCanNavigateToProductsFromHeader() {
        homePage = new HomePage(driver);
        productListingPage = new ProductListingPage(driver);
        homePage.navigate();
        homePage.clickProductsLink();
        productListingPage.assertThatUserIsOnProductListingPage();
    }

    @Test
    public void validateUserCanNavigateToCartFromHeader() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        homePage.navigate();
        homePage.clickCartLink();
        cartPage.assertThatUserIsOnCartPage();
    }

    @Test
    public void validateLogoutLinkVisibleAfterLogin() {
        homePage = new HomePage(driver);
        signupLoginPage = new SignUpLoginPage(driver);
        homePage.navigate();
        homePage.clickSignupLoginBtn();
        signupLoginPage.login("amrm@qa.team", "12345678");
        homePage.assertUserLoggedIn();
        homePage.assertThatLogoutLinkIsVisible();
        homePage.assertThatLoggedInBannerIsVisible();
    }
}
