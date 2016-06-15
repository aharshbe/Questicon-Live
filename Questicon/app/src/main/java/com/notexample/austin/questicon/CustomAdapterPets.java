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
public class CustomAdapterPets extends ArrayAdapter<PetsModel> {

    private Context context;

    public CustomAdapterPets(Context context, ArrayList<PetsModel> users) {
        super(context, 0, users);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PetsModel petsModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.customlayoutpet, parent, false);
        }

        TextView petName = (TextView) convertView.findViewById(R.id.namePet);
        ImageView petImage = (ImageView) convertView.findViewById(R.id.imagePet);




        petName.setText(petsModel.namePet);
        Picasso.with(context).load("http://wow.zamimg.com/images/wow/icons/large/" + petsModel.getImagePet() + ".jpg").into(petImage);




        return convertView;
    }
}
