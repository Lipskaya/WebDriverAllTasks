package org.example.page.enums;

public enum CommitUsage {
    NONE ("0"),
    ONE_YEAR ("1"),
    TREE_YEARS ("3");

    private final String commitUsage;

    CommitUsage(String commitUsage) {
        this.commitUsage = commitUsage;
    }

    @Override
    public String toString() {
        return commitUsage;
    }
}
