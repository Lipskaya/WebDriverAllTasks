package org.example.page.enums;

public enum OperatingSystems {
    FREE_DEBIAN("free"),
    PAID_WINDOWS("win"),
    PAID_RED_HAT_ENTERPRISE_LINUX("rhel");
    private final String operatingSystem;
    OperatingSystems(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    @Override
    public String toString() {
        return operatingSystem;
    }
}
