package org.example;

import org.example.page.PastebinPage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PastebinTest extends BaseTest{
    private static Browser browser;

    @Test
    public void baseTest(){
        PastebinPage page = new PastebinPage();
        page.openPage(PastebinPage.PASTEBIN_PAGE_URL);
        page.fillCode();
        page.fillExpiration();
        page.fillTitle();
        page.submitForm();

        Assert.assertTrue(page.isTitleCorrect());
        Assert.assertTrue(page.isExpirationCorrect());
        Assert.assertTrue(page.isCodeCorrect());

    }

}
