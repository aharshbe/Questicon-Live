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
 * Created by austin on 6/16/16.
 */
public class CustomAdapterLore extends ArrayAdapter<LoreModel> {
    private Context context;

    public CustomAdapterLore(Context context, ArrayList<LoreModel> users) {
        super(context, 0, users);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LoreModel loreModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutlore, parent, false);
        }

        TextView loreName = (TextView) convertView.findViewById(R.id.nameLore);
        ImageView loreImageVideo = (ImageView) convertView.findViewById(R.id.imageVideo);




        loreName.setText(loreModel.titleLore);
        Picasso.with(context).load(loreModel.getMovieIMAGE()).into(loreImageVideo);




        return convertView;
    }
}
