package org.example;

import org.example.page.PastebinPage;
import org.example.driver.Browser;
import org.example.model.pastebin.Paste;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PastebinTest extends BaseTest{
    private static Browser browser;

    @Test
     void baseTest(){
        Paste paste = new Paste();
        paste.setCode(PastebinPage.CODE);
        paste.setTitle(PastebinPage.TITLE);
        PastebinPage page = new PastebinPage();
        page.openPage();

        page.fillAllFields(paste);
        page.submitForm();

        assertTrue(page.isTitleCorrect(paste));
        assertTrue(page.isExpirationCorrect());
        assertTrue(page.isCodeCorrect(paste));

    }

    @Test
    void advancedTest(){
        Paste paste = new Paste();
        paste.setCode(PastebinPage.CODE_ADVANCED);
        paste.setTitle(PastebinPage.TITLE_ADVANCED);
        paste.setBashHighlighting(true);

        PastebinPage page = new PastebinPage();
        page.openPage();
        page.fillAllFields(paste);
        page.submitForm();

        assertTrue(page.isTitleCorrect(paste));
        assertTrue(page.isExpirationCorrect());
        assertTrue(page.isCodeCorrect(paste));
        assertTrue(page.isHighlightingBash());
    }


}
