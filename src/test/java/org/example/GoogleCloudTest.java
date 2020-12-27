package org.example;

import org.example.page.*;
import org.example.page.enums.*;
import org.example.page.model.cloud.VirtualMachine;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class GoogleCloudTest extends BaseTest {

    private int googleCloudTab = 0;
    private int tenEmailTab = 1;


    @Test
    void baseTest() {
        GoogleCloudPage page = new GoogleCloudPage();

        page.openPage();
        page.closeCookiesDialog();
        page.performSearch("Google Cloud Platform Pricing Calculator");
        page.clickFirstSearchResult();
        page.clickComputeEngine();
        page.fillNumberOfInstances(4);

        VirtualMachine vm = createVirtualMachine();

        page.fillVirtualMachineParameters(vm);

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

        TenMinuteEmailPage tenMinuteEmailPage = new TenMinuteEmailPage();
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

    private VirtualMachine createVirtualMachine() {
        VirtualMachine vm = new VirtualMachine();
        vm.setOperatingSystems(OperatingSystems.FREE_DEBIAN);
        vm.setMachineClass("Regular");
        vm.setSeries("N1");
        vm.setMachineType(MachineType.N1_STANDARD_8);
        vm.setNumberOfGPUs("1");
        vm.setGpuType(GPUType.NVIDIA_TESLA_v100);
        vm.setLocalSSD("2");
        vm.setLocation(Location.FRANKFURT);
        return vm;

    }

}
