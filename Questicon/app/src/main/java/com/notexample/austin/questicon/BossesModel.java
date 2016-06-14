package com.notexample.austin.questicon;

/**
 * Created by austin on 6/13/16.
 */
public class BossesModel {
    String name, description, level, health, journalid;

    public BossesModel(String name, String description, String level, String health, String journalid) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.level = level;
        this.journalid = journalid;
    }

    public String getName() {
        return name;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJournalid() {
        return journalid;
    }

    public void setJournalid(String journalid) {
        this.journalid = journalid;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
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
