package org.example;

import org.example.driver.Browser;
import org.example.util.TestListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {
    private static Browser browser;

    @BeforeAll//открывает браузер перед выполнением сценария
    public static void setup() {
        browser = Browser.getInstance();
    }

    @AfterAll
    public static void tearDown() {
        //browser.stopBrowser();
    }
}
