package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import com.github.javafaker.Faker;
import jdk.jfr.Description;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest{

    HomePage homePage ;
    SignUpLoginPage signUpLoginPage ;
    Faker faker = new Faker();
    String randomEmail;


    @Test(priority = 1)
    @Description("Validate that user can create new account successfully")
    public void validateThatUserCanCreateNewAccount()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);
        randomEmail = faker.internet().emailAddress();

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.enterSignUpNameAndEmail("Abdulrahman" , randomEmail);
        signUpLoginPage.createAccount("123456789");
        signUpLoginPage.assertRegistrationSuccess();
    }

    @Test
    @Description("Validate that user cannot create account with existing email")
    public void validateThatUserCannotCreateAccountWithExistingEmail()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.enterSignUpNameAndEmail("Abdulrahman" , "abdo.ayman.ha@gmail.com");
        signUpLoginPage.assertEmailExistsError();
    }

    @Test
    @Description("Validate that user cannot proceed to account info page without entering an email")
    public void validateThatEmailIsMandatoryInSignUpForm()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.enterSignUpNameAndEmail("Abdulrahman" , "");
        signUpLoginPage.assertEmptyFieldMissingErrorMessage();
    }

}
