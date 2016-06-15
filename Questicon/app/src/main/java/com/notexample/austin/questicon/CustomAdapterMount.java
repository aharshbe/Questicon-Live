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
public class CustomAdapterMount extends ArrayAdapter<MountModel> {

    private Context context;

    public CustomAdapterMount(Context context, ArrayList<MountModel> users) {
        super(context, 0, users);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MountModel mountModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutmount, parent, false);
        }

        TextView mountName = (TextView) convertView.findViewById(R.id.nameMount);
        ImageView mountImage = (ImageView) convertView.findViewById(R.id.imageMount);




        mountName.setText(mountModel.nameMount);
        Picasso.with(context).load("http://wow.zamimg.com/images/wow/icons/large/" + mountModel.getImageurl() + ".jpg").into(mountImage);




        return convertView;
    }
}