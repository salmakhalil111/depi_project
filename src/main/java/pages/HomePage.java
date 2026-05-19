package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// HomePage: the main page of the website (header + navigation bar)
public class HomePage extends BasePage {

    // ---- Locators ----
    By logo            = By.cssSelector("a[href='/'] img");
    By productsLink    = By.cssSelector("a[href='/products']");
    By cartLink        = By.cssSelector("a[href='/view_cart']");
    By signupLoginLink = By.cssSelector("a[href='/login']");
    By logoutLink      = By.cssSelector("a[href='/logout']");
    By deleteAccount   = By.cssSelector("a[href='/delete_account']");
    By contactUsLink   = By.cssSelector("a[href='/contact_us']");
    By testCasesLink   = By.cssSelector("a[href='/test_cases']");
    By apiListLink     = By.cssSelector("a[href='/api_list']");
    By loggedInText    = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // open the home page
    public void open() {
        driver.get("https://automationexercise.com/");
    }

    // click on Products in the navbar
    public ProductsPage goToProducts() {
        click(productsLink);
        return new ProductsPage(driver);
    }

    // click on Signup / Login
    public LoginPage goToLogin() {
        click(signupLoginLink);
        return new LoginPage(driver);
    }

    // ---- Check methods used in assertions ----
    public boolean isLogoDisplayed()         { return isDisplayed(logo); }
    public boolean isProductsLinkVisible()   { return isDisplayed(productsLink); }
    public boolean isCartLinkVisible()       { return isDisplayed(cartLink); }
    public boolean isContactUsLinkVisible()  { return isDisplayed(contactUsLink); }
    public boolean isTestCasesLinkVisible()  { return isDisplayed(testCasesLink); }
    public boolean isApiListLinkVisible()    { return isDisplayed(apiListLink); }
    public boolean isSignupLoginVisible()    { return isDisplayed(signupLoginLink); }
    public boolean isLogoutVisible()         { return isDisplayed(logoutLink); }
    public boolean isDeleteAccountVisible()  { return isDisplayed(deleteAccount); }
    public boolean isLoggedInTextVisible()   { return isDisplayed(loggedInText); }

    public String getLoggedInUsername() {
        String fullText = getText(loggedInText); // "Logged in as Salma"
        return fullText.replace("Logged in as", "").trim();
    }
}
