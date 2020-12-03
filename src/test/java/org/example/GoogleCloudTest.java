package org.example;

import org.example.page.*;
import org.example.page.enums.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class GoogleCloudTest extends BaseTest{

    private int googleCloudTab = 0;
    private int tenEmailTab = 1;


    @Test
     void baseTest() {
        GoogleCloudPage page = new GoogleCloudPage(GoogleCloudPage.GOOGLE_CLOUD_PAGE_URL);
        page.openPage();
        page.performSearch("Google Cloud Platform Pricing Calculator");
        page.clickFirstSearchResult();
        page.clickComputeEngine();
        page.fillNumberOfInstances(4);
        page.fillOperatingSystem(OperatingSystems.FREE_DEBIAN);
        page.fillMachineClass("Regular");
        page.fillSeries("N1");
        page.fillMachineType(MachineType.N1_STANDARD_8);
        page.chooseAddGPUs();
        page.fillNumberOfGPUs("1");
        page.fillGPUType(GPUType.NVIDIA_TESLA_v100);
        page.fillLocalSSD("2");
        page.fillDatacenterlocation(Location.FRANKFURT);
        page.fillCommitUsage(CommitUsage.ONE_YEAR);
        page.tabAddToEstimate();

        assertTrue(page.isVMClassCorrect());
        assertTrue(page.isInstanceTypeCorrect());
        assertTrue(page.isRegionCorrect());
        assertTrue(page.islocalSSDCorrect());
        assertTrue(page.isCommitMentTermCorrect());
        assertTrue(page.isTotalEstimatedCostCorrect());
        page.chooseEmailEstimate();
        page.openNewTab();

        TenMinuteEmailPage tenMinuteEmailPage = new TenMinuteEmailPage(TenMinuteEmailPage.TEN_MINUTE_EMAIL_PAGE_URL);
        tenMinuteEmailPage.openPage();
        String email = tenMinuteEmailPage.getCopyEmailAddress();
        tenMinuteEmailPage.changeTab(googleCloudTab);

        page.sendEmail(email);
        tenMinuteEmailPage.changeTab(tenEmailTab);
        tenMinuteEmailPage.openEmailWithTitle("Google Cloud Platform Price Estimate");
        String emailPrice = tenMinuteEmailPage.getTotalPrice();

        page.changeTab(googleCloudTab);
        String calculatedPrice = page.getTotalPrice();

        assertEquals(emailPrice, calculatedPrice);

    }

}
