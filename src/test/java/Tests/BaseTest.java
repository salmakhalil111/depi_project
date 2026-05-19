package Tests;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;

    @Parameters({"browser" , "headless"})
    @BeforeMethod
    public void setUp(@Optional("edge") String browser , @Optional("True") String headless)
    {
        driver = DriverFactory.initDriver(browser , headless);
    }

    /*@AfterMethod
    //public void tearDown(ITestResult result)
    //{
        if(result.getStatus() == ITestResult.FAILURE)
        {
            ScreenShotUtils.takeScreenshot(driver , result.getName());
        }
        DriverFactory.quitDriver(driver);
    }*/
}
