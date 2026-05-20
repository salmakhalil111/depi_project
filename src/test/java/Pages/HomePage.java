package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    //======================================== Variables ==============================//
    private final String url = "https://automationexercise.com/";
    //======================================== Driver =================================//
    private final WebDriver driver;

    //======================================== Constructor ===========================//
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //========================================== Locators ============================//
    private final By signupLogin_btn = By.xpath("//a[@href=\"/login\"]");
    private final By logout_btn = By.xpath("//a[@href=\"/logout\"]");
    private final By logo_img = By.xpath("//div[@class='logo pull-left']/a/img");
    private final By home_link = By.xpath("//a[@href='/' and contains(.,'Home')]");
    private final By products_link = By.xpath("//a[@href='/products']");
    private final By cart_link = By.xpath("//a[@href='/view_cart' and contains(., 'Cart')]");
    private final By contactUs_link = By.xpath("//a[@href='/contact_us']");
    private final By testCases_link = By.xpath("//a[@href='/test_cases']");
    private final By apiList_link = By.xpath("//a[@href='/api_list']");
    private final By deleteAccount_link = By.xpath("//a[@href='/delete_account']");
    private final By loggedInAs_txt = By.xpath("//a[contains(.,'Logged in as')]");

    //========================================= Actions ===============================//
    public void navigate() {
        driver.get(url);
    }

    public void clickSignupLogin() {
        ElementActions.click(driver , signupLogin_btn);
    }

    public void clickSignupLoginBtn() {
        ElementActions.click(driver , signupLogin_btn);
    }

    public void clickLogout() {
        ElementActions.click(driver, logout_btn);
    }

    public void clickProductsLink() {
        ElementActions.click(driver, products_link);
    }

    public void clickCartLink() {
        ElementActions.click(driver, cart_link);
    }

    public void clickContactUsLink() {
        ElementActions.click(driver, contactUs_link);
    }

    public void clickTestCasesLink() {
        ElementActions.click(driver, testCases_link);
    }

    //======================================== Assertions ===============================//
    public void assertUserLoggedInSuccessfully() {
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(), "Logout button is not displayed - User is not logged in");
    }

    public void assertUserFailedLogIn() {
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(), "Logout button is not displayed - User is not logged in");
    }

    public void assertUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout_btn));
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(), "Logout button is not displayed, user might not be logged in.");
        Assert.assertEquals(driver.getCurrentUrl() , url);
    }

    public void assertThatUserIsOnHomePage() {
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"),
                "Page title should contain 'Automation Exercise'");
        Assert.assertTrue(driver.findElement(logo_img).isDisplayed(), "Logo should be displayed");
    }

    public void assertThatNavbarLinksAreVisibleForGuest() {
        Assert.assertTrue(driver.findElement(home_link).isDisplayed(),        "Home link not visible");
        Assert.assertTrue(driver.findElement(products_link).isDisplayed(),    "Products link not visible");
        Assert.assertTrue(driver.findElement(cart_link).isDisplayed(),        "Cart link not visible");
        Assert.assertTrue(driver.findElement(signupLogin_btn).isDisplayed(),  "Signup/Login link not visible");
        Assert.assertTrue(driver.findElement(contactUs_link).isDisplayed(),   "Contact Us link not visible");
        Assert.assertTrue(driver.findElement(testCases_link).isDisplayed(),   "Test Cases link not visible");
        Assert.assertTrue(driver.findElement(apiList_link).isDisplayed(),     "API List link not visible");
    }

    public void assertThatSignupLoginLinkIsVisible() {
        Assert.assertTrue(driver.findElement(signupLogin_btn).isDisplayed(),
                "Guest should see 'Signup / Login' link");
    }

    public void assertThatLogoutLinkIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout_btn));
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(),
                "Logged-in user should see 'Logout' link");
        Assert.assertTrue(driver.findElement(deleteAccount_link).isDisplayed(),
                "Logged-in user should see 'Delete Account' link");
    }

    public void assertThatLoggedInBannerIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAs_txt));
        Assert.assertTrue(driver.findElement(loggedInAs_txt).isDisplayed(),
                "'Logged in as ...' banner should be visible");
    }
}
