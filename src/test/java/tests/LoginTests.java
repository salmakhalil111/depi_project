package tests;

import tests.BaseTest;
import pages.HomePage;
import pages.SignUpLoginPage;
import testData.LoginDataProvider;
import jdk.jfr.Description;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest{

 
    @Test(dataProvider = "loginData" , dataProviderClass = LoginDataProvider.class)
    @Description("Validate that user can login successfully with valid credentials")
    public void validateThatUserCanLoginSuccessfullyWithValidCredentials(String email , String password)
    {
        homePage = new HomePage(getDriver());
        signUpLoginPage = new SignUpLoginPage(getDriver());

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
        homePage = new HomePage(getDriver());
        signUpLoginPage = new SignUpLoginPage(getDriver());

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login(email , password);
        signUpLoginPage.assertWrongCredentials();
    }

    @Test
    @Description("Validate that user cannot login with non valid email format")
    public void validateThatUserCannotLoginWithInvalidEmailFormat(){
        homePage = new HomePage(getDriver());
        signUpLoginPage = new SignUpLoginPage(getDriver());

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login("lmgmail.com" , "1234");
        signUpLoginPage.assertEmailWrongFormat();
    }

    @Test(dataProvider = "EmptyFields" , dataProviderClass = LoginDataProvider.class)
    @Description("Validate that user cannot login with non valid email format")
    public void validateThatUserCannotLoginWithEmptyFields(String email, String password){
        homePage = new HomePage(getDriver());
        signUpLoginPage = new SignUpLoginPage(getDriver());

        homePage.navigate();
        homePage.clickSignupLogin();
        signUpLoginPage.login(email , password);
        signUpLoginPage.assertEmptyFieldMissingErrorMessage();
    }

    @Test
    @Description("Validatetaht user can logout from his account")
    public void validateLogout()
    {
        homePage = new HomePage(getDriver());
        signUpLoginPage = new SignUpLoginPage(getDriver());

        homePage.navigate();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.login("abdo.ayman.ha@gmail.com" , "123456");
        homePage.clickLogout();
        signUpLoginPage.assertUserLoggedOut();
    }
}
