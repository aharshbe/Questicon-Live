package com.notexample.austin.questicon;

/**
 * Created by austin on 6/13/16.
 */
public class CharacterModel {
    String name, battlegroup, image, newRaceName;
    int race, classwow, gender, level, achievmentpoints, faction, honorkills;

    public String getNewRaceName() {
        return newRaceName;
    }

    public void setNewRaceName(String newRaceName) {
        this.newRaceName = newRaceName;
    }

    public CharacterModel(String name, String battlegroup, String image, int race, int classwow, int gender, int level, int achievmentpoints, int faction, int honorkills, String newRaceName) {
        this.name = name;
        this.newRaceName = newRaceName;

        this.battlegroup = battlegroup;
        this.image = image;
        this.race = race;
        this.classwow = classwow;
        this.gender = gender;
        this.level = level;
        this.achievmentpoints = achievmentpoints;
        this.faction = faction;
        this.honorkills = honorkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBattlegroup() {
        return battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getClasswow() {
        return classwow;
    }

    public void setClasswow(int classwow) {
        this.classwow = classwow;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAchievmentpoints() {
        return achievmentpoints;
    }

    public void setAchievmentpoints(int achievmentpoints) {
        this.achievmentpoints = achievmentpoints;
    }

    public int getFaction() {
        return faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public int getHonorkills() {
        return honorkills;
    }

    public void setHonorkills(int honorkills) {
        this.honorkills = honorkills;
    }
}
