package com.walid.MuslimRoad;

public class item_maincard1 {
    private String text;
    private String number;
    private String title;

    public item_maincard1(String text, String number, String title) {
        this.text = text;
        this.number = number;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
