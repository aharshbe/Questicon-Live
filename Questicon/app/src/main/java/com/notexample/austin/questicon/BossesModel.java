package com.notexample.austin.questicon;

/**
 * Created by austin on 6/13/16.
 */
public class BossesModel {
    String name, description;

    public BossesModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
