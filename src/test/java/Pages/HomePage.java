package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    // =================== Variables =====================

    private final String url = "https://automationexercise.com/";

    // =================== Driver ========================

    private final WebDriver driver ;

    // =================== Constructor ===================

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // =================== Locators ======================

    private final By signupLogin_btn = By.xpath("//a[@href='/login']");


    // =================== Actions =======================

    public void navigate() {
        driver.get(url);
    }

    public void clickSignupLoginBtn() {
        ElementActions.click(driver , signupLogin_btn);
    }



    // =================== Assertions ====================

    public void assertAtHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), url );
    }
}
