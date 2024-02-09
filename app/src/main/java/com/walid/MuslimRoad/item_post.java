package com.walid.MuslimRoad;

public class item_post {
    private String imge;
    private String textunderimage;
    private String title;
    private String textheder;

    public item_post() {
    }

    public item_post(String imge, String textunderimage, String title, String textheder) {
        this.imge = imge;
        this.textunderimage = textunderimage;
        this.title = title;
        this.textheder = textheder;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public String getTextunderimage() {
        return textunderimage;
    }

    public void setTextunderimage(String textunderimage) {
        this.textunderimage = textunderimage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextheder() {
        return textheder;
    }

    public void setTextheder(String textheder) {
        this.textheder = textheder;
    }
}
