package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver initDriver(String browser , String headless)
    {
        WebDriver driver ;

        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless.equalsIgnoreCase("true"))
                {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Chrome Driver Started !!");
                break;
            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless.equalsIgnoreCase("true"))
                {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                System.out.println("Edge Driver Started !!");
                break;
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless.equalsIgnoreCase("true"))
                {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("Firefox Driver Started !!");
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver ;
    }

    public static void quitDriver(WebDriver driver)
    {
        driver.quit();
    }
}


