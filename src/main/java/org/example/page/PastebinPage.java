package org.example.page;

public class PastebinPage extends BasePage {
    public static final String PASTEBIN_PAGE_URL = "https://pastebin.com/";
    private static final String POST_FORM_XPATH = "//*[@id='postform-text']";

    private static final String PAST_EXPIRATION_XPATH = "//div[@class='form-group field-postform-expiration']//span[contains(@class, 'select2-selection--single')]";
    private static final String TEN_MINUTES_XPATH = "//li[text() ='10 Minutes']";
    private static final String FORM_NAME_XPATH ="//*[@id='postform-name']";
    public static final String CODE = "Hello from WebDriver";
    public static final String TITLE = "helloweb";
    private static final String SUBMIT_BUTTON_XPATH="//button[text()='Create New Paste']";

    public PastebinPage() {
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

    public boolean isTitleCorrect(String title){
        boolean result = false;
        try {
            //генерим динамический xPath для переданного в параметре метода имени папки
            String xpathString = "//h1";
            waitVisible(xpathString);
            result = title.equals(waitVisible(xpathString).getText());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isExpirationCorrect(){
        boolean result = false;

        try {
            //генерим динамический xPath для переданного в параметре метода имени папки
            String xpathString = "//div[@class='expire']";
            waitVisible(xpathString);
            result = "10 MIN".equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isCodeCorrect(String value){
        boolean result = false;

        try {
            //генерим динамический xPath для переданного в параметре метода имени папки
            String xpathString = "//textarea[@class='textarea']";
            waitVisible(xpathString);
            result = value.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
