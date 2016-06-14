package com.notexample.austin.questicon;

/**
 * Created by austin on 6/14/16.
 */
public class DungeonModel {
    String nameD, descriptionD, location, bossesName, bossesDes;
    String numPlayers, maxLvl, minLvl, floors;

    public DungeonModel(String nameD, String descriptionD, String location, String bossesName, String bossesDes, String numPlayers, String maxLvl, String minLvl, String floors) {
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

    public String getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getMaxLvl() {
        return maxLvl;
    }

    public void setMaxLvl(String maxLvl) {
        this.maxLvl = maxLvl;
    }

    public String getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(String minLvl) {
        this.minLvl = minLvl;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }
}
