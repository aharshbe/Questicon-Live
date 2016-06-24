package com.notexample.austin.questicon;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by austin on 6/13/16.
 */
public class CustomAdapterBosses extends ArrayAdapter<BossesModel> {
    private Context context;
    String URLString, URLString2;


    public CustomAdapterBosses(Context context, ArrayList<BossesModel> users) {
        super(context, 0, users);
        this.context = context;

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
        ImageView bossImage =(ImageView) convertView.findViewById(R.id.bossesImageView);


        name.setText(bossesModel.name);
        description.setText(bossesModel.description);
        Bosshealth.setText("Boss health:" + " " + bossesModel.health);
        Bosslevel.setText("Boss level:" + " " + bossesModel.level);

        URLString = "http://www.wowroyal.cz/sites/wowroyal.cz/files/boss-image/" + bossesModel.getName() + ".jpg";
        URLString2 = URLString.replaceAll("\\s+", "_");
        Picasso.with(context).load("http://vignette2.wikia.nocookie.net/wowwiki/images/0/0e/Skull_64.png/revision/latest?cb=20090624015657").into(bossImage);


        return convertView;
    }




}