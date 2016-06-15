package com.notexample.austin.questicon;

/**
 * Created by austin on 6/14/16.
 */
public class PetsModel {
    String namePet, imagePet;

    public PetsModel(String namePet, String imagePet) {
        this.namePet = namePet;
        this.imagePet = imagePet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getImagePet() {
        return imagePet;
    }

    public void setImagePet(String imagePet) {
        this.imagePet = imagePet;
    }
}
