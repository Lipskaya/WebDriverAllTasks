package org.example.page.enums;

public enum Location {
    FRANKFURT ("europe-west3"),
    LAS_VEGAS ("us-west4"),
    TAIWAN ("asia-east1"),
    LONDON ("europe-west2");
    private final String location;
    Location(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return location;
    }
}
