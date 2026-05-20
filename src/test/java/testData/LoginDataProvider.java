package testData;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData()
    {
        return new Object[][]{
                {"lm@gmail.com" , "1234"},
                {"abdo.ayman.ha@gmail.com" , "123456"},
//                {"abdo.ayman.ha222@gmail.com" , "123456"},
//                {"abdo.ayman.ha2223@gmail.com" , "123456"}
        };
    }

    // test case 1 : valid email and non valid password
    // test case 2 : non valid email and valid password
    // test case 3 : non valid email and non valid password
    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData()
    {
        return new Object[][]{
                {"lm@gmail.com" , "123456"},
                {"lml@gmail.com" , "1234"},
                {"llm@gmail.com" , "123456"},
                {"abdo.ayman.ha@gmail.com" , "wrongpassword"},
        };
    }

    // test case 1 : empty email and valid password
    // test case 2 : valid email and empty password
    // test case 3 : empty email and empty password
    @DataProvider(name = "EmptyFields")
    public Object[][] getEmptyLoginData()
    {
        return new Object[][]{
                {"" , "1234"},
                {"lm@gmail.com" , ""},
                {"" , ""},
        };
    }
}
