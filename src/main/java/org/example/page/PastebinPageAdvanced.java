package org.example.page;

public class PastebinPageAdvanced extends PastebinPage{

    private static final String PAST_HIGHLIGHTING_XPATH = "//div[@class='col-sm-9 field-wrapper']//span[contains(@id, 'select2-postform-format-container')]";
    private static final String BASH_XPATH = "//li[text()='Bash']";
    public static final String CODE_ADVANCED = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
    public static final String TITLE_ADVANCED = "how to gain dominance among developers";

    public void fillBashHighlighting(){
        waitVisible(PAST_HIGHLIGHTING_XPATH).click();
        waitVisible(BASH_XPATH).click();
    }

    public boolean isHighlightingBash(){
        boolean result = false;

        try {
            //генерим динамический xPath для переданного в параметре метода имени папки
            String xpathString = "//ol[@class='bash']";
            waitVisible(xpathString);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}
