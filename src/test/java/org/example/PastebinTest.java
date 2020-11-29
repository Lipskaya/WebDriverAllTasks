package org.example;

import org.example.page.PastebinPage;
import org.example.page.PastebinPageAdvanced;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PastebinTest extends BaseTest{
    private static Browser browser;

    @Test
    public void baseTest(){
        PastebinPage page = new PastebinPage();
        page.openPage(PastebinPage.PASTEBIN_PAGE_URL);
        page.fillCode(PastebinPage.CODE);
        page.fillExpiration();
        page.fillTitle(PastebinPage.TITLE);
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect(PastebinPage.TITLE));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(PastebinPage.CODE));

    }

    @Test
    public void advancedTest(){

        PastebinPageAdvanced page = new PastebinPageAdvanced();
        page.openPage(PastebinPage.PASTEBIN_PAGE_URL);
        page.fillCode(PastebinPageAdvanced.CODE_ADVANCED);
        page.fillBashHighlighting();
        page.fillExpiration();
        page.fillTitle(PastebinPageAdvanced.TITLE_ADVANCED);
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect(PastebinPageAdvanced.TITLE_ADVANCED));
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect(PastebinPageAdvanced.CODE_ADVANCED));
        Assert.assertTrue("Highlighting is not bash",page.isHighlightingBash());
    }


}
