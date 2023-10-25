package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.service.TestDataReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Browser implements WrapsDriver {
    private static Browser instance;
    private static WebDriver driver;
    private static Wait<WebDriver> wait;
    private final Logger logger = LogManager.getRootLogger();

    private Browser() {
        switch (TestDataReader.getTestData("testdata.browser.name")) {
            case "firefox": {
                logger.info("Creating firefox driver" );
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                logger.info("Creating edge driver" );
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            default: {
                logger.info("Creating default chrome driver" );
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Duration timeout = Duration.ofSeconds(30);
        Duration pollingInterval = Duration.ofMillis(500);
        wait = new WebDriverWait(driver, timeout, pollingInterval)
                .withMessage("Element was not found in X seconds");
    }
    public static Browser getInstance() {
        if (instance == null || driver == null) {
            instance = new Browser();
        }
        return instance;
    }
    public WebDriver getWrappedDriver() {
        return driver;
    }
    public static void stopBrowser() {
        try {
            getInstance().getWrappedDriver().quit();
            getInstance().driver = null;
            instance = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void open(String url) {
        driver.get(url);
    }
    public WebElement highlightElement(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.border='3px solid red'", element);
        }
        return element;
    }
    public WebElement waitVisible(String xpathLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
        WebElement el = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        el = highlightElement(el);
        return el;
    }
    public WebElement waitClickable(String xpathLocator) {
        waitVisible(xpathLocator);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
        return el;
    }
}
