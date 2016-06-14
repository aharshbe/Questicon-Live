package com.notexample.austin.questicon;

/**
 * Created by austin on 6/14/16.
 */
public class MountModel {
    String nameMount, imageurlMount;

    public MountModel(String name, String imageurl) {
        this.nameMount = name;
        this.imageurlMount = imageurl;
    }

    public String getName() {
        return nameMount;
    }

    public void setName(String name) {
        this.nameMount = name;
    }

    public String getImageurl() {
        return imageurlMount;
    }

    public void setImageurl(String imageurl) {
        this.imageurlMount = imageurl;
    }
}
