package org.example.page.enums;

public enum GPUType {

    NVIDIA_TESLA_K80("NVIDIA_TESLA_K80"),
    NVIDIA_TESLA_P100("NVIDIA_TESLA_P100"),
    NVIDIA_TESLA_p4("NVIDIA_TESLA_P4"),
    NVIDIA_TESLA_v100("NVIDIA_TESLA_V100");

    private final String gpuType;

    GPUType(String gpuType) {
        this.gpuType = gpuType;
    }

    @Override
    public String toString() {
        return gpuType;
    }
}
