package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    static WebDriverWait wait ;

    public static void click(WebDriver driver , By elementLocator)
    {
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        driver.findElement(elementLocator).click();
    }

    public static void type(WebDriver driver , By elementLocator , String text)
    {
        wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(text);
    }
    public static void hoverOverElement( WebDriver driver,By elementLocator) {
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(driver.findElement(elementLocator))
                .perform();
    }

}
