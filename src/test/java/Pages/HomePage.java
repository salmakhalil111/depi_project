package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

    // ==================== Variables ====================
    private final String url = "https://automationexercise.com/";

    // ==================== Driver ====================
    private final WebDriver driver ;

    // ==================== Constructor ====================
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================== Locators ====================
    private final By signupLogin_btn = By.xpath("//a[@href='/login']");
    private final By logout_button = By.xpath("//a[@href='/logout']");

    // ==================== Actions ====================
    public void clickSignupLoginBtn() {
        ElementActions.click(driver , signupLogin_btn);
    }

    public void navigate() {
        driver.get(url);
    }

    public void clickLogout()
    {
        ElementActions.click(driver, logout_button);
    }

    // ==================== Assertions ====================
    public void assertUserLoggedIn() {
        WebDriverWait wait= new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout_button));
        Assert.assertTrue(driver.findElement(logout_button).isDisplayed(), "Logout button is not displayed, user might not be logged in.");
        Assert.assertEquals(driver.getCurrentUrl() , url);
    }
}
