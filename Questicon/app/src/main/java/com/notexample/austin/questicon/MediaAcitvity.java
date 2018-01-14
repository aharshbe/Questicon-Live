package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MediaAcitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_acitvity);
    }

    public void clickingWallpapers(View view) {
        Intent intent = new Intent(MediaAcitvity.this, WallpaperAcitivty.class);
        startActivity(intent);
    }
}
