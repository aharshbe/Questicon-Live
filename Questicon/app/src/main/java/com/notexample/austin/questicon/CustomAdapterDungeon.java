package com.notexample.austin.questicon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by austin on 6/14/16.
 */
public class CustomAdapterDungeon extends ArrayAdapter<DungeonModel> {
    private Context context;

    public CustomAdapterDungeon(Context context, ArrayList<DungeonModel> users) {
        super(context, 0, users);
        this.context = context;
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
        ImageView dunImage =(ImageView) convertView.findViewById(R.id.dungeonsImageView);


        dungeonName.setText(dungeonModel.nameD);
        dungeonDescription.setText(dungeonModel.descriptionD);
        minLevel.setText("Minimum Level:" + " " + dungeonModel.minLvl);
        maxLevel.setText("Maximum level:" + " " + dungeonModel.maxLvl);
        Picasso.with(context).load("http://media.blizzard.com/wow/legion-6a153ad2/images/spectral-sight-icon.png").into(dunImage);


        return convertView;
    }
}