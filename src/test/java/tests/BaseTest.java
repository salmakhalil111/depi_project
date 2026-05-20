package tests;

import driver.DriverFactory;
import utils.ScreenShotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {


    public WebDriver driver;

    @Parameters({"browser" , "headless"})
    @BeforeMethod
    public void Preconditions(@Optional("edge") String browserName , @Optional("true") String headless ) {
        driver = DriverFactory.initDriver(browserName , headless);
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Test Case Failed !!!");
            ScreenShotUtils.takeScreenshot(driver , result.getName());
        }
        DriverFactory.quitDriver(driver);
    }





}
