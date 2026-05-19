package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

// DriverFactory: creates a new browser ready for testing.
// If grid.enabled=true in config.properties => it connects to the Selenium Grid Hub.
// Otherwise it runs the browser locally on this machine.
public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = ConfigReader.get("browser").toLowerCase();
        boolean gridEnabled = Boolean.parseBoolean(ConfigReader.get("grid.enabled"));

        WebDriver driver;
        try {
            if (gridEnabled) {
                // ---- Run on Selenium Grid (remote) ----
                String gridUrl = ConfigReader.get("grid.url");
                System.out.println("Running on Selenium Grid: " + gridUrl + " (browser=" + browser + ")");

                if (browser.equals("firefox")) {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new RemoteWebDriver(new URL(gridUrl), options);
                } else {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    driver = new RemoteWebDriver(new URL(gridUrl), options);
                }
            } else {
                // ---- Run locally ----
                System.out.println("Running locally (browser=" + browser + ")");
                if (browser.equals("firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create WebDriver: " + e.getMessage(), e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.get("implicit.wait"))));
        return driver;
    }
}
