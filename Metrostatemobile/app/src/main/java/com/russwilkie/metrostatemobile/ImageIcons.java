package com.russwilkie.metrostatemobile;

/**
 * Created by izhar on 12/16/2017.
 */

public class ImageIcons {

    private String name;
    private int image;

    public ImageIcons(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
