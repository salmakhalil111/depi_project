package tests;

import tests.BaseTest;
import driver.DriverFactory;
import utils.ScreenShotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    
    public WebDriver driver;

    @Parameters({"browser" , "headless" , "executionType"})
    @BeforeMethod
    public void Preconditions(@Optional("edge") String browserName , @Optional("true") String headless, @Optional("local") String executionType ) {
       WebDriver driver = DriverFactory.initDriver(browserName , headless , executionType);
         threadLocalDriver.set(driver);
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
