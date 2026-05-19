package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import TestData.LoginDataProvider;
import jdk.jfr.Description;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest{

    HomePage homePage;
    SignUpLoginPage signUpLoginPage ;


    @Test(dataProvider = "loginData" , dataProviderClass = LoginDataProvider.class)
    @Description("Validate that user can login successfully with valid credentials")
    public void validateThatUserCanLoginSuccessfullyWithValidCredentials(String email , String password)
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login(email , password);
        homePage.assertUserLoggedInSuccessfully();
    }

    @Test(dataProvider = "invalidLoginData" , dataProviderClass = LoginDataProvider.class)
    @Description("Validate that user cannot login with invalid Credentials")
    public void validateThatUserCannotLoginWithValidEmailAndNonValidPassword(String email,
                                                                             String password)
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login(email , password);
        signUpLoginPage.assertWrongCredentials();
    }

    @Test
    @Description("Validate that user cannot login with non valid email format")
    public void validateThatUserCannotLoginWithInvalidEmailFormat(){
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login("lmgmail.com" , "1234");
        signUpLoginPage.assertEmailWrongFormat();
    }

    @Test(dataProvider = "EmptyFields" , dataProviderClass = LoginDataProvider.class)
    @Description("Validate that user cannot login with non valid email format")
    public void validateThatUserCannotLoginWithEmptyFields(String email, String password){
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login(email , password);
        signUpLoginPage.assertEmptyFieldMissingErrorMessage();
    }
}
