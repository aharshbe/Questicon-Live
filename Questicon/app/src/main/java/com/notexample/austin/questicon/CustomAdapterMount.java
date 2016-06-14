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
public class CustomAdapterMount extends ArrayAdapter<MountModel> {

    public CustomAdapterMount(Context context, ArrayList<MountModel> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MountModel mountModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutmount, parent, false);
        }

        TextView mountName = (TextView) convertView.findViewById(R.id.nameMount);




        mountName.setText(mountModel.nameMount);




        return convertView;
    }
}