package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;

// BaseTest: every test class extends this one.
// It opens the browser once before the entire TestNG suite and closes it after the suite finishes.
public class BaseTest {

    // shared driver for the whole test suite
    protected static WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        if (driver == null) {
            driver = DriverFactory.createDriver();
            System.out.println("Browser opened (suite)");
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed (suite)");
        }
    }
}

