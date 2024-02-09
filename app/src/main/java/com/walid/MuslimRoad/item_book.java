package com.walid.MuslimRoad;

public class item_book {
    private String namebook;
    private String imgebook;
    private  String bookread;
    private String bookdownlod;

    public item_book() {
    }

    public item_book(String namebook, String imgebook, String bookread, String bookdownlod) {
        this.namebook = namebook;
        this.imgebook = imgebook;
        this.bookread = bookread;
        this.bookdownlod = bookdownlod;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getImgebook() {
        return imgebook;
    }

    public void setImgebook(String imgebook) {
        this.imgebook = imgebook;
    }

    public String getBookread() {
        return bookread;
    }

    public void setBookread(String bookread) {
        this.bookread = bookread;
    }

    public String getBookdownlod() {
        return bookdownlod;
    }

    public void setBookdownlod(String bookdownlod) {
        this.bookdownlod = bookdownlod;
    }
}
