package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignUpLoginPage {
    //======================================== Variables ==============================//
    private final String url = "https://automationexercise.com/login";
    private final String emailExistErrorMessage = "Email Address already exist!";
    //======================================== Driver =================================//
    private final WebDriver driver ;

    //======================================== Constructor ===========================//
    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //========================================== Locators ============================//
    private final By name_textBox = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By email_textBox = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUp_btn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By maleGender_rbtn = By.id("id_gender1");
    private final By password_textBox = By.id("password");
    private final By newsletter_checkbox = By.id("newsletter");
    private final By offers_checkbox = By.id("optin");
    private final By firstName_textBox = By.id("first_name");
    private final By lastName_textBox = By.id("last_name");
    private final By company_textBox = By.id("company");
    private final By address1_textBox = By.id("address1");
    private final By address2_textBox = By.id("address2");
    private final By state_textBox = By.id("state");
    private final By city_textBox = By.id("city");
    private final By zipcode_textBox = By.id("zipcode");
    private final By mobileNumber_textBox = By.id("mobile_number");
    private final By createAccount_btn = By.xpath("//button[@data-qa=\"create-account\"]");
    private final By accountCreated_message = By.xpath("//*[@data-qa=\"account-created\"]");
    private final By emailExists_errorMessage = By.xpath("//form[@action=\"/signup\"]/p");
    private final By loginEmail_textBox = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginPassword_textBox = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By login_btn = By.xpath("//button[@data-qa=\"login-button\"]");
    private final By login_form = By.className("login-form");
    private final By wrongCredentials_errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");

    //========================================= Actions ===============================//
    public void enterSignUpNameAndEmail(String name , String email)
    {
        ElementActions.fill(driver , name_textBox , name);
        ElementActions.fill(driver , email_textBox , email);
        driver.findElement(signUp_btn).click();
    }

    public void enterNameAndEmail(String name, String email) {
        enterSignUpNameAndEmail(name, email);
    }

    public void createAccount(String password) {
        driver.findElement(maleGender_rbtn).click();
        driver.findElement(password_textBox).sendKeys(password);

        driver.findElement(firstName_textBox).sendKeys("John");
        driver.findElement(lastName_textBox).sendKeys("Doe");
        driver.findElement(company_textBox).sendKeys("TechCorp");
        driver.findElement(address1_textBox).sendKeys("123 Main Street");
        driver.findElement(address2_textBox).sendKeys("Apt 4B");
        driver.findElement(state_textBox).sendKeys("California");
        driver.findElement(city_textBox).sendKeys("Los Angeles");
        driver.findElement(zipcode_textBox).sendKeys("90001");
        driver.findElement(mobileNumber_textBox).sendKeys("1234567890");

        driver.findElement(createAccount_btn).click();
    }

    public void createNewAccount(String password) {
        driver.findElement(maleGender_rbtn).click();
        driver.findElement(password_textBox).sendKeys(password);
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_textBox).sendKeys("John");
        driver.findElement(lastName_textBox).sendKeys("Doe");
        driver.findElement(address1_textBox).sendKeys("123 Main St");
        driver.findElement(address2_textBox).sendKeys("Apt 4");
        driver.findElement(state_textBox).sendKeys("California");
        driver.findElement(city_textBox).sendKeys("Los Angeles");
        driver.findElement(zipcode_textBox).sendKeys("90001");
        driver.findElement(mobileNumber_textBox).sendKeys("1234567890");
        driver.findElement(createAccount_btn).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmail_textBox).sendKeys(email);
        driver.findElement(loginPassword_textBox).sendKeys(password);
        driver.findElement(login_btn).click();
    }

    //======================================== Assertions ===============================//
    public void assertRegistrationSuccess() {
        Assert.assertTrue(driver.findElement(accountCreated_message).isDisplayed(), "Account created message is not displayed");

        SoftAssert softAssert = new SoftAssert();
        String successMessageText = driver.findElement(accountCreated_message).getText();
        softAssert.assertEquals(successMessageText, "ACCOUNT CREATED!", "Expected message 'Account Created!' but got '" + successMessageText + "'");
        softAssert.assertAll();
    }

    public void assertAccountCreated() {
        Assert.assertTrue(driver.findElement(accountCreated_message).isDisplayed(), "Account created message should be displayed");
        Assert.assertEquals(driver.findElement(accountCreated_message).getText(), "ACCOUNT CREATED!", "Account created message text should match");
    }

    public void assertEmailExistsError() {
        Assert.assertTrue(driver.findElement(emailExists_errorMessage).isDisplayed(), "Email exists error message is not displayed");

        String errorMessageText = driver.findElement(emailExists_errorMessage).getText();
        Assert.assertEquals(errorMessageText, emailExistErrorMessage, "Expected message 'Email Address already exist!' but got '" + errorMessageText + "'");
    }

    public void assertEmptyFieldMissingErrorMessage()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = js.executeScript("return document.querySelector('[data-qa=\"signup-email\"]').validationMessage;").toString();
        Assert.assertEquals(msg , "Please fill out this field." , "Expected message 'Please' but got '" + msg + "'");
    }

    public void assertWrongCredentials () {
        String errorMessageText = driver.findElement(wrongCredentials_errorMessage).getText();
        Assert.assertEquals(errorMessageText, "Your email or password is incorrect!",
                "Expected message 'Your email or password is incorrect!' but got '" + errorMessageText + "'");
    }

    public void assertUserLoginErrorMessage() {
        Assert.assertTrue(driver.findElement(wrongCredentials_errorMessage).isDisplayed() , "Login error message should be displayed for invalid credentials");
    }

    public void assertUserLoggedOut() {
        Assert.assertTrue(driver.findElement(login_form).isDisplayed() , "User didn't navigate to Login page after logout");
    }

    public void assertEmailWrongFormat(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String msg = js.executeScript("return document.querySelector('[data-qa=\"login-email\"]').validationMessage;").toString();
        Assert.assertEquals(msg , "Please include an '@' in the email address. 'lmgmail.com' is missing an '@'." , "Expected message 'Please include an '@' in the email address. 'lmgmail.com' is missing an '@'.' but got '" + msg + "'");
    }
}
