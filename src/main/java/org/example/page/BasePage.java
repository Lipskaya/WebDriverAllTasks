package org.example.page;

import org.example.Browser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class BasePage {

    private Browser browser;

    public BasePage() {
        browser = Browser.getInstance();
    }

    // Ждет пока указанный элемент не появится на странице и не станет видимым (опрос элемента происходит в соответствии с настройками wait)
    public WebElement waitVisible(String xpathLocator) {
        WebElement el = browser.waitVisible(xpathLocator);
        return el;
    }

    public void openPage(String url) {
        browser.open(url);
    }
    public void openNewTab(){
        //from here: https://sqa.stackexchange.com/questions/32756/how-to-open-two-separate-tabs-in-same-google-chrome-window-using-webdriver-and-j
        ((JavascriptExecutor)browser.getWrappedDriver()).executeScript("window.open()");
        //получаем в список все открытые вкладки в браузере
        ArrayList<String> tabs = new ArrayList<String>(browser.getWrappedDriver().getWindowHandles());
        browser.getWrappedDriver().switchTo().window(tabs.get(1));
    }
    public void changeTab(int tabNumber){
        ArrayList<String> tabs = new ArrayList<String>(browser.getWrappedDriver().getWindowHandles());
        browser.getWrappedDriver().switchTo().window(tabs.get(tabNumber));
    }
}
