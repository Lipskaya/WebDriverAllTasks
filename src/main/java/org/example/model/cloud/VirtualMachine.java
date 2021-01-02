package org.example.model.cloud;

import org.example.page.enums.GPUType;
import org.example.page.enums.Location;
import org.example.page.enums.MachineType;
import org.example.page.enums.OperatingSystems;

public class VirtualMachine {
    private OperatingSystems operatingSystems;
    private String machineClass;
    private String series;
    private MachineType machineType;
    private String numberOfGPUs;
    private GPUType gpuType;
    private String localSSD;
    private Location location;

    public OperatingSystems getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(OperatingSystems operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public GPUType getGpuType() {
        return gpuType;
    }

    public void setGpuType(GPUType gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
