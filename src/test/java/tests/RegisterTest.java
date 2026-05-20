package tests;

import tests.BaseTest;
import pages.MainHomePage;
import pages.SignUpLoginPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Random;


public class RegisterTest extends BaseTest {



    Faker faker = new Faker((Random) getDriver());








    @Test ( description = "Validate that User can Register successfully with Valid Credentials")
    public void validateCreatingNewAccount()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("Test", email);
        signUpLoginPage.createNewAccount();
        signUpLoginPage.assertAccountCreated();
    }



    @Test ( description = "Validate that user proceed to Account Information Page when entering both valid name and email")
    public void userProceedToSignupForm()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("Test", email);
        signUpLoginPage.assertSignupFormPage();

    }




    @Test (description = "Validate that error message appears when user leaves email field empty")
    public void userCanNotRegisterWithMissingEmail()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("test", "");
        signUpLoginPage.assertPopupEmailErrorMsg();
        signUpLoginPage.assertUserAtSignupLoginPage();

    }

    @Test (description = "Validate that error message appears when user leaves name field empty")
    public void userCanNotRegisterWithMissingName()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("", email);
        signUpLoginPage.assertPopupNameErrorMsg();
        signUpLoginPage.assertUserAtSignupLoginPage();


    }

    @Test (description = "Validate that error message appears when user enters invalid email format")
    public void userCanNotRegisterWithInvalidEmail()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("test", "test@");
        signUpLoginPage.assertEmailFormatErrorPopupMsg();
        signUpLoginPage.assertUserAtSignupLoginPage();

    }



    @Test (description = " Validate that inline error message appears when user enters duplicate Email registration")
    public void userCanNotRegisterWithDuplicatedEmail()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("test", "testtt30@gmail.com");
        signUpLoginPage.assertErrorMsg();

    }


    @Test ( description = "Validate that the registration proceeds successfully when a strong password is entered on the Account Information page")
    public void validateCreatingNewAccountWithStrongPassword()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("Test", email);
        signUpLoginPage.enterPassword("MySecureP@ssw0rd!23");
        signUpLoginPage.assertStrongPassword();

    }

    @Test ( description = "Validate that the registration can't proceed successfully when a weak password is entered on the Account Information page")
    public void validateCreatingNewAccountWithWeakPassword()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("Test", email);
        signUpLoginPage.enterPassword("12");
        signUpLoginPage.assertPopupPasswordErrorMsg();
    }

    @Test ( description = "Validate that user can't create account when all required details are empty")
    public void validateUserCanNotRegisterWithEmptyFields()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("test", email);
        signUpLoginPage.emptyRegistrationInformation();
        signUpLoginPage.assertPopupPasswordErrorMsg();
        signUpLoginPage.assertSignupFormPage();
    }

    @Test ( description = "Validate that user can't create account when all required details are invalid")
    public void validateUserCanNotRegisterWithInvalidInformation()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("test", email);
        signUpLoginPage.registrationWithInvalidInformation();
        signUpLoginPage.assertSignupFormPage();
    }


    @Test ( description = "Validate that registration can't proceed and error message appears when user enters extremely long name")
    public void validateUserCanNotRegisterWithExtremeLongName()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", email);
        signUpLoginPage.assertPopupLongNameErrorMsg();
        signUpLoginPage.assertUserAtSignupLoginPage();
    }

    @Test ( description = "Validate that registration can't proceed and error message appears when user enters special character name")
    public void validateUserCanNotRegisterWithSpecialCharacter()
    {

        MainHomePage homePage = new MainHomePage(getDriver());
        String email = faker.internet().emailAddress();
        SignUpLoginPage signUpLoginPage = new SignUpLoginPage(getDriver());


        homePage.open();
        homePage.clickSignupLoginBtn();
        signUpLoginPage.enterNameAndEmail("@", email);
        signUpLoginPage.assertPopupSpecialCharacterErrorMsg();
        signUpLoginPage.assertUserAtSignupLoginPage();
    }













}
