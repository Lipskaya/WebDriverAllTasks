package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.Browser;
import org.example.page.enums.*;
import org.example.model.cloud.VirtualMachine;
import org.openqa.selenium.*;

public class GoogleCloudPage extends BasePage {
    private final Logger logger = LogManager.getRootLogger();
    private Browser browser;
    private static final String SCROLL_SCRIPT = "arguments[0].scrollIntoView(true);";
    private static final String GOOGLE_CLOUD_PAGE_URL = " https://cloud.google.com/";
    private static final String SEARCH_XPATH = " //input[@name='q']";
    private static final String FIRST_RESULT_XPATH = "(//a[@class='gs-title']/b)[1]";
    private static final String COMPUTE_ENGINE_XPATH = "//*[@id='tab-item-1']//div/span[text()='Compute Engine']";
    private static final String NUMBER_OF_INSTANCES_XPATH = "//input[@ng-model='listingCtrl.computeServer.quantity']";
    private static final String MACHINE_CLASS_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.class']";
    private static final String OPERATING_SYSTEM_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.os']";
    private static final String SERIES_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.series']";
    private static final String MACHINE_TYPE_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.instance']";
    private static final String ADD_GPUS_CHECKBOX_XPATH = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']";
    private static final String NUMBER_OF_GPUS_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']";
    private static final String GPUS_TYPE_XPATH = "//md-select[@placeholder='GPU type']";
    private static final String LOCAL_SSD_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.ssd']";
    private static final String DATACENTER_LOCATION_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.location']";
    private static final String COMMIT_USAGE_XPATH = "//md-select[@ng-model='listingCtrl.computeServer.cud']";
    private static final String ADD_TO_ESTIMATE_XPATH = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']";
    private static final String EMAIL_ESTIMATE_XPATH = "//button[@title='Email Estimate']";
    private static final String EMAIL_YOUR_ESTIMATE_XPATH = "//span[text()='Email Your Estimate']";
    private static final String PAST_EMAIL_ADDRESS = "//input[@ng-model='emailQuote.user.email']";
    private static final String SEND_EMAIL_XPATH = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and contains(text(), 'Send Email')]";
    private static final String COOKIES_OK_XPATH = "//button[text()='OK']";
    private static final String NEW_CLICKABLE_PREFIX = "//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']//md-option[@value='";
    private static final String CLICKABLE_PREFIX = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='";
    private static final String CLICKABLE_POSTFIX = "']";

    public GoogleCloudPage() {
        super(GOOGLE_CLOUD_PAGE_URL);
        browser = Browser.getInstance();
        logger.info("Created GoogleCloudPage" );
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
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        waitVisible(COMPUTE_ENGINE_XPATH).click();
    }
    public void fillNumberOfInstances(Integer numberOfInstances) {
        waitVisible(NUMBER_OF_INSTANCES_XPATH).click();
        waitVisible(NUMBER_OF_INSTANCES_XPATH).sendKeys(numberOfInstances.toString());
    }
    public void fillMachineClass(String machineClass) {
        String machineClassXPath = CLICKABLE_PREFIX + machineClass.toLowerCase() + CLICKABLE_POSTFIX;
        WebElement element = waitVisible(COMPUTE_ENGINE_XPATH);
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
        WebElement element = waitVisible(MACHINE_CLASS_XPATH);
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        waitVisible(ADD_GPUS_CHECKBOX_XPATH).click();
    }
    public void fillNumberOfGPUs(String numberOfGPUS) {
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
        String locationXpath = NEW_CLICKABLE_PREFIX + location + CLICKABLE_POSTFIX;
        waitVisible(DATACENTER_LOCATION_XPATH).click();
        browser.waitClickable(locationXpath).click();
    }
    public void fillCommitUsage(CommitUsage usage) {
        String usageXpath = CLICKABLE_PREFIX + usage + CLICKABLE_POSTFIX;
        waitVisible(COMMIT_USAGE_XPATH).click();
        browser.waitClickable(usageXpath).click();
    }
    public void tabAddToEstimate() {
        WebElement element = waitVisible(DATACENTER_LOCATION_XPATH);
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
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        WebElement element = waitVisible(EMAIL_YOUR_ESTIMATE_XPATH);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor) browser.getWrappedDriver()).executeScript(SCROLL_SCRIPT, element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitVisible(PAST_EMAIL_ADDRESS).sendKeys(email);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitVisible(SEND_EMAIL_XPATH).click();
    }

    public String getTotalPrice() {
        WebDriver driver = browser.getWrappedDriver();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        return waitVisible("//h2/b[@class = 'ng-binding']").getText()
                .replace("Total Estimated Cost:", "")
                .replace("per 1 month", "").trim();
    }
    public boolean isVMClassCorrect() {
        boolean result = false;
        try {
            String expectedValue = "Provisioning model: Regular";
            String xpathString = "//div[contains(text(),'Provisioning model: Regular')]";
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
            String expectedValue = "Instance type: n1-standard-8\n" +
                    "Committed Use Discount applied";
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
            String expectedValue = "Local SSD: 2x375 GiB\n" +
                    "Committed Use Discount applied";
            String xpathString = "//div[contains(text(),'Local SSD: 2x375 GiB')]";
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
            String expectedValue = "Region: Frankfurt";
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
            String expectedValue = "Commitment term: 1 Year";
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
            String xpathString = "//b[contains(text(),'Estimated Component Cost:') and contains( text(),'USD 1,081.20')  and contains( text(),'per 1 month')]";
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
        chooseAddGPUs();
        fillGPUType(vm.getGpuType());
        fillNumberOfGPUs(vm.getNumberOfGPUs());
        fillLocalSSD(vm.getLocalSSD());
        fillDatacenterlocation(vm.getLocation());
    }
}
