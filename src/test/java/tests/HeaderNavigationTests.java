package tests;

import tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

// Feature 5: Header navigation (Guest vs Logged-in user)
public class HeaderNavigationTests extends BaseTestTwo {

    // TC01: Page title contains "Automation Exercise"
    @Test(priority = 1)
    public void homepageTitleIsCorrect() {
        HomePage home = new HomePage(driver);
        home.open();
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),
                "Page title should contain 'Automation Exercise'");
    }

    // TC02: As a guest, "Signup / Login" link is visible
    @Test(priority = 2)
    public void guestSeesSignupLoginLink() {
        HomePage home = new HomePage(driver);
        home.open();
        Assert.assertTrue(home.isSignupLoginVisible(),
                "Guest user should see 'Signup / Login' link");
        Assert.assertFalse(home.isLogoutVisible(),
                "Guest user should NOT see 'Logout' link");
    }

    // TC03: All main navbar links are visible for a guest
    @Test(priority = 3)
    public void allNavbarLinksVisibleForGuest() {
        HomePage home = new HomePage(driver);
        home.open();
        Assert.assertTrue(home.isLogoDisplayed(),        "Logo should be visible");
        Assert.assertTrue(home.isProductsLinkVisible(),  "Products link should be visible");
        Assert.assertTrue(home.isCartLinkVisible(),      "Cart link should be visible");
        Assert.assertTrue(home.isContactUsLinkVisible(), "Contact Us link should be visible");
        Assert.assertTrue(home.isTestCasesLinkVisible(), "Test Cases link should be visible");
        Assert.assertTrue(home.isApiListLinkVisible(),   "API List link should be visible");
    }

    // TC04: After login, "Logout" link is visible (uses placeholder credentials)
    // NOTE: This test will fail until real credentials are set in config.properties.
    @Test(priority = 4)
    public void loggedInUserSeesLogoutLink() {
        HomePage home = new HomePage(driver);
        home.open();
        LoginPage login = home.goToLogin();
        Assert.assertTrue(login.isLoginFormVisible(), "Login form should be visible");

        String email    = ConfigReader.get("test.email");
        String password = ConfigReader.get("test.password");
        login.login(email, password);

        Assert.assertTrue(home.isLogoutVisible(),
                "After login, user should see 'Logout' link");
        Assert.assertTrue(home.isDeleteAccountVisible(),
                "After login, user should see 'Delete Account' link");
    }

    // TC05: After login, the "Logged in as <username>" banner shows the right name
    @Test(priority = 5)
    public void loggedInUsernameIsShown() {
        HomePage home = new HomePage(driver);
        home.open();
        LoginPage login = home.goToLogin();

        String email    = ConfigReader.get("test.email");
        String password = ConfigReader.get("test.password");
        String expectedUsername = ConfigReader.get("test.username");

        login.login(email, password);
        Assert.assertTrue(home.isLoggedInTextVisible(), "'Logged in as ...' should appear");
        Assert.assertEquals(home.getLoggedInUsername(), expectedUsername,
                "Logged-in username should match the test account");
    }
}
