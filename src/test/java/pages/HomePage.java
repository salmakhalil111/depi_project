package pages;

import utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    //======================================== Variables ==============================//
    private final String url = "https://automationexercise.com/";
    //======================================== driver =================================//
    private final WebDriver driver;

    //======================================== Constructor ===========================//
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //========================================== Locators ============================//
    private final By signupLogin_btn = By.xpath("//a[@href=\"/login\"]");
    private final By logout_btn = By.xpath("//a[@href=\"/logout\"]");

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

    //======================================== Assertions ===============================//
    
      public void assertAtHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), url );
    }

    
    
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
}
