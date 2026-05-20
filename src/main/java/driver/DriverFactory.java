package driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver initDriver(String browser, String headless, String executionType)  {

        WebDriver driver;

        boolean isHeadless = headless.equalsIgnoreCase("true");
        boolean isRemote = executionType.equalsIgnoreCase("remote");

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                }

                if (isRemote) {
                    try {
                        driver = new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                chromeOptions
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Chrome browser launched successfully on Selenium Grid.");
                } else {
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("Chrome browser launched successfully locally.");
                }

                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();

                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }

                if (isRemote) {
                    try {
                        driver = new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                edgeOptions
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Edge browser launched successfully on Selenium Grid.");
                } else {
                    driver = new EdgeDriver(edgeOptions);
                    System.out.println("Edge browser launched successfully locally.");
                }

                break;

            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                if (isRemote) {
                    try {
                        driver = new RemoteWebDriver(
                                new URL("http://localhost:4444"),
                                firefoxOptions
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Firefox browser launched successfully on Selenium Grid.");
                } else {
                    driver = new FirefoxDriver(firefoxOptions);
                    System.out.println("Firefox browser launched successfully locally.");
                }

                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


    public static WebDriver initDriver(String browser , String headless)
    {
        return setDriver(browser, headless);
    }

    private static WebDriver setDriver(String browser, String headless) {
        WebDriver driver;

        boolean isHeadless = headless.equalsIgnoreCase("true");

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                System.out.println("Chrome browser launched successfully.");
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                System.out.println("Edge browser launched successfully.");
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("Firefox browser launched successfully.");
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void quitDriver(WebDriver driver)
    {
        driver.quit();
    }
}
