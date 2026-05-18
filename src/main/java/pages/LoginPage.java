package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// LoginPage: the /login page (login form on the left side)
public class LoginPage extends BasePage {

    // ---- Locators ----
    By loginEmail    = By.cssSelector("input[data-qa='login-email']");
    By loginPassword = By.cssSelector("input[data-qa='login-password']");
    By loginButton   = By.cssSelector("button[data-qa='login-button']");
    By loginHeading  = By.xpath("//h2[normalize-space()='Login to your account']");
    By errorMessage  = By.xpath("//p[contains(text(),'incorrect')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // check that the login form is shown
    public boolean isLoginFormVisible() {
        return isDisplayed(loginHeading);
    }

    // log in with email and password
    public HomePage login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginButton);
        return new HomePage(driver);
    }

    // check if "incorrect email or password" message appears
    public boolean isErrorVisible() {
        return isDisplayed(errorMessage);
    }
}
