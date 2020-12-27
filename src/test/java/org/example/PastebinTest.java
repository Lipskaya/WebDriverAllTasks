package org.example;

import org.example.page.PastebinPage;
import org.example.page.driver.Browser;
import org.example.page.model.pastebin.Paste;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

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

        Assert.assertTrue(page.isTitleCorrect(paste));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(paste));

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

        Assert.assertTrue(page.isTitleCorrect(paste));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(paste));
        Assert.assertTrue("Highlighting is not bash",page.isHighlightingBash());
    }


}
