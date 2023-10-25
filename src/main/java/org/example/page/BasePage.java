package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.Browser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class BasePage {
    private Browser browser;
    private String url;
    private final Logger logger = LogManager.getRootLogger();
    public BasePage(String url) {
        browser = Browser.getInstance();
        this.url = url;
    }
    public WebElement waitVisible(String xpathLocator) {
        WebElement el = browser.waitVisible(xpathLocator);
        return el;
    }
    public void openPage(){
        browser.open(url);
        logger.info("Page opened");
    }
    public void openNewTab(){
        ((JavascriptExecutor)browser.getWrappedDriver()).executeScript("window.open()");//получаем в список все открытые вкладки в браузере
        ArrayList<String> tabs = new ArrayList<String>(browser.getWrappedDriver().getWindowHandles());
        browser.getWrappedDriver().switchTo().window(tabs.get(1));
    }
    public void changeTab(int tabNumber){
        ArrayList<String> tabs = new ArrayList<String>(browser.getWrappedDriver().getWindowHandles());
        browser.getWrappedDriver().switchTo().window(tabs.get(tabNumber));
    }
}
