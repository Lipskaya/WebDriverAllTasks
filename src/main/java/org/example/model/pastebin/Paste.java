package org.example.model.pastebin;

import org.example.page.PastebinPage;

public class Paste {
    private String code;
    private String title;
    private boolean isBashHighlighting;

    public boolean isBashHighlighting() {
        return isBashHighlighting;
    }

    public void setBashHighlighting(boolean bashHighlighting) {
        isBashHighlighting = bashHighlighting;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

