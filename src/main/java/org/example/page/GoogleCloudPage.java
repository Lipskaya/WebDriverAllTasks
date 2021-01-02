package org.example.page;

import org.example.driver.Browser;
import org.example.page.enums.*;
import org.example.model.cloud.VirtualMachine;
import org.openqa.selenium.*;

public class GoogleCloudPage extends BasePage {

    private Browser browser;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView(true);";
    private static final String GOOGLE_CLOUD_PAGE_URL = " https://cloud.google.com/";
    private static final String SEARCH_XPATH = " //input[@name='q']";
    private static final String FIRST_RESULT_XPATH = "(//a[@class='gs-title']/b)[1]";
    private static final String COMPUTE_ENGINE_XPATH = "//md-tab-item//div[text()='Compute Engine']";
    private static final String NUMBER_OF_INSTANCES_XPATH = "//input[@ng-model='listingCtrl.computeServer.quantity']";
    private static final String MACHINE_CLASS_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.class']";
    private static final String OPERATING_SYSTEM_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.os']";
    private static final String SERIES_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.series']";
    private static final String MACHINE_TYPE_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.instance']";
    private static final String ADD_GPUS_CHECKBOX_XPATH = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']";
    private static final String NUMBER_OF_GPUS_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']";
    private static final String GPUS_TYPE_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']";
    private static final String LOCAL_SSD_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.ssd']";
    private static final String DATACENTER_LOCATION_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.location']";
    private static final String COMMIT_USAGE_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.cud']";
    private static final String ADD_TO_ESTIMATE_XPATH = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";
    private static final String EMAIL_ESTIMATE_XPATH = "//button[@aria-label='Email Estimate']";
    private static final String EMAIL_YOUR_ESTIMATE_XPATH = "//span[text()='Email Your Estimate']";
    private static final String PAST_EMAIL_ADDRESS = "//input[@ng-model='emailQuote.user.email']";
    private static final String SEND_EMAIL_XPATH = "//button[@aria-label='Send Email']";
    private static final String COOKIES_OK_XPATH = "//button[text()='OK']";
    private static final String CLICKABLE_PREFIX = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='";
    private static final String CLICKABLE_POSTFIX = "']";

    public GoogleCloudPage() {
        super(GOOGLE_CLOUD_PAGE_URL);
        browser = Browser.getInstance();
    }


    public void performSearch(String searchValue) {
        waitVisible(SEARCH_XPATH).click();
        waitVisible(SEARCH_XPATH).sendKeys(searchValue);
        waitVisible(SEARCH_XPATH).sendKeys(Keys.ENTER);
    }

    public void clickFirstSearchResult() {

        waitVisible(FIRST_RESULT_XPATH).click();
    }

    public void clickComputeEngine() {
        WebDriver driver = browser.getWrappedDriver();
        driver.switchTo().frame(0);//Переключаемяся на первый iframe
        driver.switchTo().frame(0); //Переключаемяся на первый iframe внутри родительского iframe

        waitVisible(COMPUTE_ENGINE_XPATH).click();//Причина почему код не работал в том, что мы пытались кликнуть по НЕВИДИМОМУ элементу. Наш waitVisible метод позволяет КЛИКАТЬ тольео по тем элементам, которые видны

    }

    public void fillNumberOfInstances(Integer numberOfInstances) {
        waitVisible(NUMBER_OF_INSTANCES_XPATH).click();
        waitVisible(NUMBER_OF_INSTANCES_XPATH).sendKeys(numberOfInstances.toString());
    }

    public void fillMachineClass(String machineClass) {
        // находим вебэлемент - до которого нужно прокрутить страницу
        String machineClassXPath = CLICKABLE_PREFIX + machineClass.toLowerCase() + CLICKABLE_POSTFIX;
        WebElement element = waitVisible(COMPUTE_ENGINE_XPATH);
        //прокручивает страницу до уазанного element
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        waitVisible(MACHINE_CLASS_XPATH).click();
        browser.waitClickable(machineClassXPath).click();
    }

    public void fillOperatingSystem(OperatingSystems operatingSystemValue) {
        String operatingSystemXpath = CLICKABLE_PREFIX + operatingSystemValue.toString() + CLICKABLE_POSTFIX;
        waitVisible(OPERATING_SYSTEM_XPATH).click();
        browser.waitClickable(operatingSystemXpath).click();
    }

    public void fillSeries(String series) {
        String seriesXPath = CLICKABLE_PREFIX + series.toLowerCase() + CLICKABLE_POSTFIX;
        waitVisible(SERIES_XPATH).click();
        browser.waitClickable(seriesXPath).click();

    }

    public void fillMachineType(MachineType machineType) {
        String machineTypeXpath = CLICKABLE_PREFIX + machineType.toString() + CLICKABLE_POSTFIX;
        waitVisible(MACHINE_TYPE_XPATH).click();
        browser.waitClickable(machineTypeXpath).click();

    }

    public void chooseAddGPUs() {
        // находим вебэлемент - до которого нужно прокрутить страницу
        WebElement element = waitVisible(MACHINE_CLASS_XPATH);
        //прокручивает страницу до уазанного element
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        waitVisible(ADD_GPUS_CHECKBOX_XPATH).click();
    }

    public void fillNumberOfGPUs(String numberOfGPUS) {
        chooseAddGPUs();
        String numberOfGPUSXpath = CLICKABLE_PREFIX + numberOfGPUS + CLICKABLE_POSTFIX;
        waitVisible(NUMBER_OF_GPUS_XPATH).click();
        browser.waitClickable(numberOfGPUSXpath).click();
    }

    public void fillGPUType(GPUType gpuType) {
        String gpuTypeXpath = CLICKABLE_PREFIX + gpuType + CLICKABLE_POSTFIX;
        waitVisible(GPUS_TYPE_XPATH).click();
        browser.waitClickable(gpuTypeXpath).click();
    }

    public void fillLocalSSD(String localSSD) {
        String localSSDXpath = CLICKABLE_PREFIX + localSSD + CLICKABLE_POSTFIX;
        waitVisible(LOCAL_SSD_XPATH).click();
        browser.waitClickable(localSSDXpath).click();
    }

    public void fillDatacenterlocation(Location location) {
        String locationXpath = CLICKABLE_PREFIX + location + CLICKABLE_POSTFIX;
        waitVisible(DATACENTER_LOCATION_XPATH).click();
        browser.waitClickable(locationXpath).click();
    }

    public void fillCommitUsage(CommitUsage usage) {
        String usageXpath = CLICKABLE_PREFIX + usage + CLICKABLE_POSTFIX;
        waitVisible(COMMIT_USAGE_XPATH).click();
        browser.waitClickable(usageXpath).click();
    }

    public void tabAddToEstimate() {
        // находим вебэлемент - до которого нужно прокрутить страницу
        WebElement element = waitVisible(DATACENTER_LOCATION_XPATH);
        //прокручивает страницу до уазанного element
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        browser.waitClickable(ADD_TO_ESTIMATE_XPATH).click();
    }

    public void chooseEmailEstimate() {
        waitVisible(EMAIL_ESTIMATE_XPATH).click();
        WebElement element = waitVisible(EMAIL_YOUR_ESTIMATE_XPATH);
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
    }

    public void sendEmail(String email) {
        WebDriver driver = browser.getWrappedDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);//Переключаемяся на первый iframe
        driver.switchTo().frame(0); //Переключаемяся на первый iframe внутри родительского iframe
        // находим вебэлемент - до которого нужно прокрутить страницу
        WebElement element = waitVisible(EMAIL_YOUR_ESTIMATE_XPATH);
        //прокручивает страницу до уазанного element
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        waitVisible(PAST_EMAIL_ADDRESS).sendKeys(email);
        waitVisible(SEND_EMAIL_XPATH).click();
    }

    public String getTotalPrice() {
        WebDriver driver = browser.getWrappedDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);//Переключаемяся на первый iframe
        driver.switchTo().frame(0); //Переключаемяся на первый iframe внутри родительского iframe
        return waitVisible("//h2/b[@class = 'ng-binding']").getText()
                .replace("Total Estimated Cost:", "")
                .replace("per 1 month", "").trim();
    }

    public boolean isVMClassCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "VM class: regular"
            String expectedValue = "VM class: regular";
            //2 Находим реальное значение VM class, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//div[contains(text(),'VM class: regular')]";
            waitVisible(xpathString);
            result = expectedValue.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isInstanceTypeCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "Instance type: n1-standard-8"
            String expectedValue = "Instance type: n1-standard-8";
            //2 Находим реальное значение, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//div[contains(text(),'Instance type: n1-standard-8')]";
            waitVisible(xpathString);
            result = expectedValue.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean islocalSSDCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "Total available local SSD space 2x375 GiB"
            String expectedValue = "Total available local SSD space 2x375 GiB";
            //2 Находим реальное значение, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//div[contains(text(),'Total available local SSD space 2x375 GiB')]";
            waitVisible(xpathString);
            result = expectedValue.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isRegionCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "Region: Frankfurt"
            String expectedValue = "Region: Frankfurt";
            //2 Находим реальное значение, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//div[contains(text(),'Region: Frankfurt')]";
            waitVisible(xpathString);
            result = expectedValue.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isCommitMentTermCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "Commitment term: 1 Year"
            String expectedValue = "Commitment term: 1 Year";
            //2 Находим реальное значение, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//div[contains(text(),'Commitment term: 1 Year')]";
            waitVisible(xpathString);
            result = expectedValue.equals(waitVisible(xpathString).getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean isTotalEstimatedCostCorrect() {
        boolean result = false;
        try {
            //1 Задаем ожидаемое значение "Total Estimated Cost: USD 1,082.77 per 1 month"
            //2 Находим реальное значение, т.е определяем XPath полученного значения из калькуляции
            String xpathString = "//b[contains(text(),'Estimated Component Cost:') and contains( text(),'USD 1,082.77')  and contains( text(),'per 1 month')]";
            waitVisible(xpathString);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public void closeCookiesDialog() {
        waitVisible(COOKIES_OK_XPATH).click();
    }

    public void fillVirtualMachineParameters(VirtualMachine vm) {
        fillOperatingSystem(vm.getOperatingSystems());
        fillMachineClass(vm.getMachineClass());
        fillSeries(vm.getSeries());
        fillMachineType(vm.getMachineType());
        fillNumberOfGPUs(vm.getNumberOfGPUs());
        fillGPUType(vm.getGpuType());
        fillLocalSSD(vm.getLocalSSD());
        fillDatacenterlocation(vm.getLocation());
    }
}
