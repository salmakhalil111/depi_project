package Tests;

import Pages.HomePage;
import Pages.SignUpLoginPage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    HomePage homePage ;
    SignUpLoginPage signUpLoginPage ;



    @Test
    @Description("Validatetaht user can logout from his account")
    public void validateLogout()
    {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUpLoginPage(driver);

        homePage.navigate();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.login("abdo.ayman.ha@gmail.com" , "123456");
        homePage.clickLogout();
        signUpLoginPage.assertUserLoggedOut();
    }
}
