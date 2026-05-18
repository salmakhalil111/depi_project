package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpLoginPage {

    // ==================== Variables ====================
    private final String url = "https://automationexercise.com/login";

    // ==================== Driver ====================
    private final WebDriver driver ;

    // ==================== Constructor ====================
    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================== Locators ====================
    private final By signupName_input = By.xpath("//input[@data-qa='signup-name']");
    private final By signupEmail_input = By.xpath("//input[@data-qa='signup-email']");
    private final By signup_btn = By.xpath("//button[@data-qa='signup-button']");
    private final By genderMale_radio = By.id("id_gender1");
    private final By password_input = By.id("password");
    private final By newsletter_checkbox = By.id("newsletter");
    private final By offers_checkbox = By.id("optin");
    private final By firstName_input = By.id("first_name");
    private final By lastName_input = By.id("last_name");
    private final By address1_input = By.id("address1");
    private final By address2_input = By.id("address2");
    private final By state_input = By.id("state");
    private final By city_input = By.id("city");
    private final By zipcode_input = By.id("zipcode");
    private final By mobileNumber_input = By.id("mobile_number");
    private final By createAccount_btn = By.xpath("//button[@data-qa='create-account']");
    private final By accountCreated_msg = By.xpath("//h2[@data-qa='account-created']");
    private final By loginEmail_input = By.xpath("//input[@data-qa='login-email']");
    private final By loginPassword_input = By.xpath("//input[@data-qa='login-password']");
    private final By login_btn = By.xpath("//button[@data-qa='login-button']");
    private final By login_form = By.className("login-form");
    private final By login_errorMsg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
    // ==================== Actions ====================
    public void enterNameAndEmail(String name, String email) {
        driver.findElement(signupName_input).sendKeys(name);
        driver.findElement(signupEmail_input).sendKeys(email);
        driver.findElement(signup_btn).click();
    }

    public void createNewAccount(String password) {
        driver.findElement(genderMale_radio).click();
        driver.findElement(password_input).sendKeys(password);
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_input).sendKeys("John");
        driver.findElement(lastName_input).sendKeys("Doe");
        driver.findElement(address1_input).sendKeys("123 Main St");
        driver.findElement(address2_input).sendKeys("Apt 4");
        driver.findElement(state_input).sendKeys("California");
        driver.findElement(city_input).sendKeys("Los Angeles");
        driver.findElement(zipcode_input).sendKeys("90001");
        driver.findElement(mobileNumber_input).sendKeys("1234567890");
        driver.findElement(createAccount_btn).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmail_input).sendKeys(email);
        driver.findElement(loginPassword_input).sendKeys(password);
        driver.findElement(login_btn).click();
    }

    // ==================== Assertions ====================
    public void assertAccountCreated() {
        Assert.assertTrue(driver.findElement(accountCreated_msg).isDisplayed(), "Account created message should be displayed");
        Assert.assertEquals(driver.findElement(accountCreated_msg).getText(), "ACCOUNT CREATED!", "Account created message text should match");
    }

    public void assertUserLoggedOut()
    {
        Assert.assertTrue(driver.findElement(login_form).isDisplayed() , "User didn't navigate to Login page after logout");
    }

    public void assertUserLoginErrorMessage()
    {
        Assert.assertTrue(driver.findElement(login_errorMsg).isDisplayed() , "Login error message should be displayed for invalid credentials");
    }
}
