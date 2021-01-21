package org.example;

import org.example.driver.Browser;
import org.example.util.TestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    private static Browser browser;

    @BeforeSuite//открывает браузер перед выполнением сценария
    public static void setup() {
        browser = Browser.getInstance();
    }

    @AfterSuite
    public static void tearDown() {

        browser.stopBrowser();
    }
}
