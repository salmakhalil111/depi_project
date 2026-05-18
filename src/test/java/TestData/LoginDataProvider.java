package TestData;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData()
    {
        return new Object[][]{
                {"abdo.ayman.ha@gmail.com" , "123456"},
                {"abdo.ayman.ha222@gmail.com" , "123456"},
//                {"abdo.ayman.ha2223@gmail.com" , "123456"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData()
    {
        return new Object[][]{
                {"abdo.ayman.ha@gmail.com" , "123456"},
//                {"abdo.ayman.ha222@gmail.com" , "123456"},
//                {"abdo.ayman.ha2223@gmail.com" , "123456"}
        };
    }
}
