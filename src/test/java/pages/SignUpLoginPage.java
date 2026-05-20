package pages;

import utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignUpLoginPage {
    //======================================== Variables ==============================//
    private final String url = "https://automationexercise.com/login";

    //======================================== driver =================================//
    private final WebDriver driver ;

    //======================================== Constructor ===========================//
    public SignUpLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //========================================== Locators ============================//
    private final By signupName_input = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signupEmail_input = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signupName_input = By.xpath("//input[@data-qa=\"signup-name\"]");
    private final By signupEmail_input = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signup_btn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By genderMale_radio = By.id("id_gender1");
    private final By genderFemale_radio = By.id("id_gender2");
    private final By password_input = By.id("password");
    private final By newsletter_checkbox = By.id("newsletter");
    private final By offers_checkbox = By.id("optin");
    private final By firstName_input = By.id("first_name");
    private final By lastName_input = By.id("last_name");
    private final By company_input = By.id("company");
    private final By address1_input = By.id("address1");
    private final By address2_input = By.id("address2");
    private final By state_input = By.id("state");
    private final By city_input = By.id("city");
    private final By zipcode_input = By.id("zipcode");
    private final By mobileNumber_input = By.id("mobile_number");
    private final By createAccount_btn = By.xpath("//button[@data-qa=\"create-account\"]");
    private final By accountCreated_msg = By.xpath("//h2[@data-qa=\"account-created\"]");
    private final By enterAccountInformationTitle = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
    private final By emailError_msg = By.xpath("//p[text()='Email Address already exist!']");
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
     public void enterNameAndEmail(String name, String email) {
        driver.findElement(signupName_input).sendKeys(name);
        driver.findElement(signupEmail_input).sendKeys(email);
        ElementActions.click(driver , signup_btn);
    }

public void createNewAccount() {
        driver.findElement(genderMale_radio).click();
        driver.findElement(password_input).sendKeys("123456");
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_input).sendKeys("John");
        driver.findElement(lastName_input).sendKeys("Doe");
        driver.findElement(company_input).sendKeys("ABC Corp");
        driver.findElement(address1_input).sendKeys("123 Main St");
        driver.findElement(address2_input).sendKeys("Apt 4");
        driver.findElement(state_input).sendKeys("California");
        driver.findElement(city_input).sendKeys("Los Angeles");
        driver.findElement(zipcode_input).sendKeys("90001");
        driver.findElement(mobileNumber_input).sendKeys("1234567890");
        ElementActions.click(driver , createAccount_btn);
    }

    public void enterPassword(String password) {
        driver.findElement(genderMale_radio).click();
        driver.findElement(password_input).sendKeys(password);
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_input).sendKeys("");

    }


    public void emptyRegistrationInformation() {
        driver.findElement(genderMale_radio).click();
        driver.findElement(password_input).sendKeys("");
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_input).sendKeys("");
        driver.findElement(lastName_input).sendKeys("");
        driver.findElement(company_input).sendKeys("");
        driver.findElement(address1_input).sendKeys("");
        driver.findElement(address2_input).sendKeys("");
        driver.findElement(state_input).sendKeys("");
        driver.findElement(city_input).sendKeys("");
        driver.findElement(zipcode_input).sendKeys("");
        driver.findElement(mobileNumber_input).sendKeys("");
        ElementActions.click(driver , createAccount_btn);
    }


    public void registrationWithInvalidInformation() {
        driver.findElement(genderMale_radio).click();
        driver.findElement(password_input).sendKeys("a");
        driver.findElement(newsletter_checkbox).click();
        driver.findElement(offers_checkbox).click();
        driver.findElement(firstName_input).sendKeys("1");
        driver.findElement(lastName_input).sendKeys("1");
        driver.findElement(company_input).sendKeys("1");
        driver.findElement(address1_input).sendKeys("1");
        driver.findElement(address2_input).sendKeys("1");
        driver.findElement(state_input).sendKeys("1");
        driver.findElement(city_input).sendKeys("1");
        driver.findElement(zipcode_input).sendKeys("1");
        driver.findElement(mobileNumber_input).sendKeys("1");
        ElementActions.click(driver , createAccount_btn);
    }



    
    
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

    public void login(String email, String password) {
        driver.findElement(loginEmail_textBox).sendKeys(email);
        driver.findElement(loginPassword_textBox).sendKeys(password);
        driver.findElement(login_btn).click();
    }

    //======================================== Assertions ===============================//
   
     public void assertAccountCreated() {
        Assert.assertTrue(driver.findElement(accountCreated_msg).isDisplayed(), "Account created message is not displayed");
        Assert.assertEquals(driver.findElement(accountCreated_msg).getText(), "ACCOUNT CREATED!", "Account created message text is incorrect");
    }

    public void assertSignupFormPage()
    {
        String url2 = "https://automationexercise.com/signup";

        Assert.assertEquals(driver.getCurrentUrl(), url2, "User is not on the Signup page");
        Assert.assertTrue(driver.findElement(password_input).isDisplayed());
        Assert.assertTrue(driver.findElement(enterAccountInformationTitle).isDisplayed());
    }

    public void assertUserAtSignupLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), url, "User is not on the Signup/Login page");
    }

    public void assertErrorMsg()
    {
        Assert.assertTrue(driver.findElement(emailError_msg).isDisplayed(), "Email error message is not displayed");
        Assert.assertEquals(driver.findElement(emailError_msg).getText(), "Email Address already exist!", "Email error message text is incorrect");
    }

    public void assertPopupEmailErrorMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(signupEmail_input));
        Assert.assertEquals(message, "Please fill in this field.", "Popup error message text is incorrect");
    }

    public void assertPopupNameErrorMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(signupName_input));
        Assert.assertEquals(message, "Please fill in this field.", "Popup error message text is incorrect");
    }

    public void assertEmailFormatErrorPopupMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(signupEmail_input));
        Assert.assertEquals(message, "Please enter a part following '@'. 'test@' is incomplete.", "Popup error message text is incorrect");
    }

    public void assertStrongPassword()
    {
        Assert.assertEquals(driver.findElement(firstName_input).getAttribute("value"), "");
    }

    public void assertPopupPasswordErrorMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(firstName_input));
        Assert.assertEquals(message, "Please fill in this field.", "Popup error message text is incorrect");
    }


    public void assertPopupLongNameErrorMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(signupName_input));
        Assert.assertEquals(message, "Name field should not exceed 20 characters", "Popup error message text is incorrect");
    }

    public void assertPopupSpecialCharacterErrorMsg()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript(
                "return arguments[0].validationMessage;", driver.findElement(signupName_input));
        Assert.assertEquals(message, "Name field should not have special characters", "Popup error message text is incorrect");
    }
    
    
    
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
