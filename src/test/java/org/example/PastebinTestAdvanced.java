package org.example;

import org.example.page.PastebinPageAdvanced;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PastebinTestAdvanced extends BaseTest{
    private static Browser browser;


    @Test
    public void baseTest(){

        PastebinPageAdvanced page = new PastebinPageAdvanced();
        page.openPage(PastebinPageAdvanced.PASTEBIN_PAGE_URL);
        page.fillCode();
        page.fillBashHighlighting();
        page.fillExpiration();
        page.fillTitle();
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect());
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect());
        Assert.assertTrue("Highlighting is not bash",page.isHighlightingBash());
    }

}
