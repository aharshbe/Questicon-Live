package com.notexample.austin.questicon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by austin on 6/13/16.
 */
public class CustomAdapterBosses extends ArrayAdapter<BossesModel> {

    public CustomAdapterBosses(Context context, ArrayList<BossesModel> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BossesModel bossesModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutbosses, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.nameBosses);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionBosses);
        TextView Bosshealth = (TextView) convertView.findViewById(R.id.BossHealth);
        TextView Bosslevel = (TextView) convertView.findViewById(R.id.LevelBoss);






        name.setText("Boss Name:"+ " " +bossesModel.name);
        description.setText("Boss description:"+ " "+bossesModel.description);
        Bosshealth.setText("Boss health:"+ " " +bossesModel.health);
        Bosslevel.setText("Boss level:"+ " "+bossesModel.level);




        return convertView;
    }
}