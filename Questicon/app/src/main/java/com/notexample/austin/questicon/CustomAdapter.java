package com.notexample.austin.questicon;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CharacterModel> {

    public CustomAdapter(Context context, ArrayList<CharacterModel> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CharacterModel character = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayout, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView battlegroup = (TextView) convertView.findViewById(R.id.battlegroup);
        TextView wowclass = (TextView) convertView.findViewById(R.id.wowclass);
        TextView race = (TextView) convertView.findViewById(R.id.race);
        TextView gender = (TextView) convertView.findViewById(R.id.gender);
        TextView ap = (TextView) convertView.findViewById(R.id.ap);
        TextView faction = (TextView) convertView.findViewById(R.id.faction);
        TextView kills = (TextView) convertView.findViewById(R.id.kills);
        TextView level = (TextView) convertView.findViewById(R.id.level);
        ImageView imageChar  = (ImageView) convertView.findViewById(R.id.image);





        name.setText("Character Name:"+ " " +character.name);
        level.setText("Character Level:"+ " "+character.faction);
        battlegroup.setText("Character Battlegroup:"+ " " +character.battlegroup);
        wowclass.setText("Character Class:"+ " " +character.classwow);
        race.setText("Character Race:"+ " " +character.newRaceName);
        gender.setText("Character Gender:"+ " " +character.gender);
        ap.setText("Character Achievement Points:"+ " " +character.level);
        faction.setText("Character Faction:"+ " " +character.achievmentpoints);
        kills.setText("Total Honor Kills:"+ " " +character.honorkills);



        return convertView;
    }
}
