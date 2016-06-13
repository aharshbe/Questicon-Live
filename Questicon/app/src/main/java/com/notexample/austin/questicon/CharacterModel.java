package com.notexample.austin.questicon;

/**
 * Created by austin on 6/13/16.
 */
public class CharacterModel {
    String name, battlegroup, image;
    int race, classwow, gender, level, achievmentpoints, faction, honorkills;

    public CharacterModel(String name, String battlegroup, String image, int race, int classwow, int gender, int level, int achievmentpoints, int faction, int honorkills) {
        this.name = name;
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
}
