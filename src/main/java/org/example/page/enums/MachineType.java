package org.example.page.enums;

public enum MachineType {
    N1_STANDARD_8("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8"),
    F1_MICRO("CP-COMPUTEENGINE-VMIMAGE-F1-MICRO");

    private final String machineType;

    MachineType(String machineType) {
        this.machineType = machineType;
    }

    @Override
    public String toString() {
        return  machineType;
    }
}
