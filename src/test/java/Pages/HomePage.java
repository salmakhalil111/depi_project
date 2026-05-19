package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

    //========================================= Actions ===============================//
    public void navigate() {
        driver.get(url);
    }

    public void clickSignupLogin() {
        ElementActions.click(driver , signupLogin_btn);
    }

    //======================================== Assertions ===============================//
    public void assertUserLoggedInSuccessfully() {
        // Assert that the logout button is displayed, which indicates user is logged in
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(), "Logout button is not displayed - User is not logged in");
    }
    public void assertUserFailedLogIn() {
        // Assert that the logout button is displayed, which indicates user is logged in
        Assert.assertTrue(driver.findElement(logout_btn).isDisplayed(), "Logout button is not displayed - User is not logged in");
    }
}
