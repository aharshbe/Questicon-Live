package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

public class SongListAcitivty extends AppCompatActivity {
    LinkedList<String> mToDoList;
    ArrayAdapter<String> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list_acitivty);

        mToDoList = new LinkedList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mToDoList);
        ListView listView = (ListView) findViewById(R.id.listViewSongsList);
        listView.setAdapter(mAdapter);


        int mySong[] = {R.raw.song1, R.raw.song2, R.raw.song1, R.raw.song2,
                R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4,
                R.raw.song5, R.raw.song6, R.raw.song7, R.raw.song8,
                R.raw.song9, R.raw.song10, R.raw.song11, R.raw.song12, R.raw.song13,
                R.raw.song14, R.raw.song16, R.raw.song17, R.raw.song18, R.raw.song19, R.raw.song20,
                R.raw.song21, R.raw.song22, R.raw.song23, R.raw.song24, R.raw.song25, R.raw.song25,
                R.raw.song26, R.raw.song27, R.raw.song28, R.raw.song29, R.raw.song30};

        for (int i = 0; i < mySong.length; i++) {

            mToDoList.add(String.valueOf(mySong[i]));


        }
        mAdapter.notifyDataSetChanged();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(SongListAcitivty.this, MusicActivity.class);
                myIntent.putExtra("position", position);
                myIntent.putExtra("song", mToDoList.get(position));
                startActivity(myIntent);
                return true;
            }
        });

    }




}


