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
        TextView battlegroup = (TextView) convertView.findViewById(R.id.levelly);
        ImageView imageChar  = (ImageView) convertView.findViewById(R.id.image);





        name.setText(character.name);
        battlegroup.setText(character.battlegroup);


        return convertView;
    }
}
