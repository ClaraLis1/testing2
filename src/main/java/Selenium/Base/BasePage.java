package Selenium.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver chromeDriverConnection() {

        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void typeInfo (String inputText,By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    public static void click (By locator) {
        driver.findElement(locator).click();
    }

    public void link (String url) {
        driver.get(url);
    }

    public void key (By locator, String tecla) {
        driver.findElement(locator).sendKeys(Keys.valueOf(tecla));
    }


    public void getText (By locator) {
        String res = driver.findElement(locator).getText();
        System.out.println("Text : " + res );
    }

    public void compareData (By locator, String texto) {
        String res = driver.findElement(locator).getText();
        assertTrue(res.contains(texto));
    }

    public void wait (int time, By locator, String texto){
        new WebDriverWait(driver, Duration.ofSeconds(time)).
                until(ExpectedConditions.textToBePresentInElementLocated(locator,texto));
    }
}






