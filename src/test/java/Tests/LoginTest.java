package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    HomePage homePage ;
    SignUpLoginPage signUpLoginPage ;

    @Test(description = "Validate that user can login successfully with valid credentials")
    public void validateUserLoginWithValidCredentials()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.login("abdo.ayman.ha@gmail.com" , "123456");
        homePage.assertUserLoggedIn();
    }

    @Test(description = "Validate that user cannot login with invalid Email")
    public void validateLoginWithInvalidEmail()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.login("invalid@invalid.com" , "123456");
        signUpLoginPage.assertUserLoginErrorMessage();
    }


}
