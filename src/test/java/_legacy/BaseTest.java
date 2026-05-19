package _legacy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;

// Legacy BaseTest copy kept for reference
public class BaseTest {

	// legacy copy - not used by tests (kept in _legacy package)
	protected static WebDriver driver;

	@BeforeSuite
	public void setUpSuite() {
		if (driver == null) {
			driver = DriverFactory.createDriver();
			System.out.println("(legacy) Browser opened (suite)");
		}
	}

	@AfterSuite
	public void tearDownSuite() {
		if (driver != null) {
			driver.quit();
			driver = null;
			System.out.println("(legacy) Browser closed (suite)");
		}
	}
}
