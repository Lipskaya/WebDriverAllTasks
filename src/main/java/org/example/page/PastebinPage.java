package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.pastebin.Paste;

public class PastebinPage extends BasePage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PASTEBIN_PAGE_URL = "https://pastebin.com/";
    private static final String POST_FORM_XPATH = "//*[@id='postform-text']";
    private static final String PAST_EXPIRATION_XPATH = "//div[@class='form-group field-postform-expiration']//span[contains(@class, 'select2-selection--single')]";
    private static final String TEN_MINUTES_XPATH = "//li[text() ='10 Minutes']";
    private static final String FORM_NAME_XPATH ="//*[@id='postform-name']";
    public static final String CODE = "Hello from WebDriver";
    public static final String TITLE = "helloweb";
    private static final String SUBMIT_BUTTON_XPATH="//button[text()='Create New Paste']";
    private static final String PAST_HIGHLIGHTING_XPATH = "//div[@class='col-sm-9 field-wrapper']//span[contains(@id, 'select2-postform-format-container')]";
    private static final String BASH_XPATH = "//li[text()='Bash']";
    public static final String CODE_ADVANCED = "git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
    public static final String TITLE_ADVANCED = "how to gain dominance among developers";

    public PastebinPage() {
        super(PASTEBIN_PAGE_URL);
        logger.info("Created PastebinPage");
    }
    public void fillCode(String value){
        waitVisible(POST_FORM_XPATH).sendKeys(value);
    }
    public void fillExpiration(){
        waitVisible(PAST_EXPIRATION_XPATH).click();
        waitVisible(TEN_MINUTES_XPATH).click();
    }
    public void fillTitle(String title){
        waitVisible(FORM_NAME_XPATH).sendKeys(title);
    }
    public void submitForm(){
        waitVisible(SUBMIT_BUTTON_XPATH).click();
    }
    public boolean isTitleCorrect(Paste paste){
        boolean result = false;
        try {
            String xpathString = "//h1";
            waitVisible(xpathString);
            result = paste.getTitle().equals(waitVisible(xpathString).getText());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public boolean isExpirationCorrect(){
        boolean result = false;
        try {
            String xpathString = "//div[@class='expire']";
            waitVisible(xpathString);
            result = "10 MIN".equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public boolean isCodeCorrect(Paste paste){
        boolean result = false;

        try {
            String xpathString = "//textarea[@class='textarea']";
            waitVisible(xpathString);
            result = paste.getCode().equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public void fillBashHighlighting(){
        waitVisible(PAST_HIGHLIGHTING_XPATH).click();
        waitVisible(BASH_XPATH).click();
    }
    public boolean isHighlightingBash(){
        boolean result = false;
        try {
            String xpathString = "//ol[@class='bash']";
            waitVisible(xpathString);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    public void fillAllFields(Paste paste){
        fillCode(paste.getCode());
        if (paste.isBashHighlighting()){
            fillBashHighlighting();
        }
        fillExpiration();
        fillTitle(paste.getTitle());
    }
}
