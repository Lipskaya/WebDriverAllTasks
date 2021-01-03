package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TenMinuteEmailPage extends BasePage{
    private final Logger logger = LogManager.getRootLogger();
    private static final String TEN_MINUTE_EMAIL_PAGE_URL = "https://10minutemail.com";
    private static final String EMAIL_INPUT_XPATH = "//input[@id='mail_address']";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String TOTAL_PRICE_XPATH = "//tr[@id='mobilepadding']//h2";

    public TenMinuteEmailPage() {
        super(TEN_MINUTE_EMAIL_PAGE_URL);
        logger.info("Created TenMinuteEmailPage" );
    }

    public String getCopyEmailAddress(){
        while (waitVisible(EMAIL_INPUT_XPATH).getAttribute(ATTRIBUTE_VALUE).trim().length() == 0){
            //ждем пока не заполнится поле адреса
        }
       return waitVisible(EMAIL_INPUT_XPATH).getAttribute(ATTRIBUTE_VALUE).trim();
    }

    public void openEmailWithTitle(String title){
        String xpath = "//div[@class='small_subject']/span[text()='" + title +"']";
        waitVisible(xpath).click();
    }

    public String getTotalPrice(){
        return waitVisible(TOTAL_PRICE_XPATH).getText()
                .replace("Estimated Monthly Cost:","").trim();
    }
}
