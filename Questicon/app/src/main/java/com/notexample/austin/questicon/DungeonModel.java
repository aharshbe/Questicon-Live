package com.notexample.austin.questicon;

/**
 * Created by austin on 6/14/16.
 */
public class DungeonModel {
    String nameD, descriptionD, location, bossesName, bossesDes;
    int numPlayers, maxLvl, minLvl, floors;

    public DungeonModel(String nameD, String descriptionD, String location, String bossesName, String bossesDes, int numPlayers, int maxLvl, int minLvl, int floors) {
        this.nameD = nameD;
        this.descriptionD = descriptionD;
        this.location = location;
        this.bossesName = bossesName;
        this.bossesDes = bossesDes;
        this.numPlayers = numPlayers;
        this.maxLvl = maxLvl;
        this.minLvl = minLvl;
        this.floors = floors;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public String getDescriptionD() {
        return descriptionD;
    }

    public void setDescriptionD(String descriptionD) {
        this.descriptionD = descriptionD;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBossesName() {
        return bossesName;
    }

    public void setBossesName(String bossesName) {
        this.bossesName = bossesName;
    }

    public String getBossesDes() {
        return bossesDes;
    }

    public void setBossesDes(String bossesDes) {
        this.bossesDes = bossesDes;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getMaxLvl() {
        return maxLvl;
    }

    public void setMaxLvl(int maxLvl) {
        this.maxLvl = maxLvl;
    }

    public int getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(int minLvl) {
        this.minLvl = minLvl;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
