package org.example;

import org.example.page.PastebinPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

 class PastebinTest extends BaseTest{
    private static Browser browser;

    @Test
     void baseTest(){
        PastebinPage page = new PastebinPage(PastebinPage.PASTEBIN_PAGE_URL);
        page.openPage();
        page.fillCode(PastebinPage.CODE);
        page.fillExpiration();
        page.fillTitle(PastebinPage.TITLE);
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect(PastebinPage.TITLE));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(PastebinPage.CODE));

    }

    @Test
    void advancedTest(){

        PastebinPage page = new PastebinPage(PastebinPage.PASTEBIN_PAGE_URL);
        page.openPage();
        page.fillCode(PastebinPage.CODE_ADVANCED);
        page.fillBashHighlighting();
        page.fillExpiration();
        page.fillTitle(PastebinPage.TITLE_ADVANCED);
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect(PastebinPage.TITLE_ADVANCED));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(PastebinPage.CODE_ADVANCED));
        Assert.assertTrue("Highlighting is not bash",page.isHighlightingBash());
    }


}
