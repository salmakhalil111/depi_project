package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;

// BaseTestTwo: similar to BaseTest but kept for compatibility.
// It opens the browser once before the TestNG suite and closes it after the suite finishes.
public class BaseTestTwo {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        if (driver == null) {
            driver = DriverFactory.createDriver();
            System.out.println("Browser opened (suite) [BaseTestTwo]");
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed (suite) [BaseTestTwo]");
        }
    }
}
