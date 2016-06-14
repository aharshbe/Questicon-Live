package com.notexample.austin.questicon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by austin on 6/14/16.
 */
public class CustomAdapterDungeon extends ArrayAdapter<DungeonModel> {

    public CustomAdapterDungeon(Context context, ArrayList<DungeonModel> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DungeonModel dungeonModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutdunegons, parent, false);
        }

        TextView dungeonName = (TextView) convertView.findViewById(R.id.nameDungeon);
        TextView dungeonDescription = (TextView) convertView.findViewById(R.id.descriptionDungeon);
        TextView minLevel = (TextView) convertView.findViewById(R.id.minLevel);
        TextView maxLevel = (TextView) convertView.findViewById(R.id.maxLevel);


        dungeonName.setText(dungeonModel.nameD);
        dungeonDescription.setText(dungeonModel.descriptionD);
        minLevel.setText("Minimum Level:" + " " + dungeonModel.minLvl);
        maxLevel.setText("Maximum level:" + " " + dungeonModel.maxLvl);


        return convertView;
    }
}