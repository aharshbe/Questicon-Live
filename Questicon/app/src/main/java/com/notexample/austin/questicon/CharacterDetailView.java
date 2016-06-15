package com.notexample.austin.questicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CharacterDetailView extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String nameChar = getIntent().getStringExtra("nameChar");
        final String nameRealm = getIntent().getStringExtra("nameRealm");

//        final String picasso = getIntent().getStringExtra("url2");
//        imageView = (ImageView) findViewById(R.id.imageView);
//        Picasso.with(this).load("https://us.battle.net/static-render/us/"+ picasso).into(imageView);
    }
}
