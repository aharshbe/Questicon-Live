package com.notexample.austin.questicon;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicActivity extends AppCompatActivity {
     MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

       mp = MediaPlayer.create(this, R.raw.a1);


    }


    public void playbutton(View view) {
        mp.start();
    }

    public void stop(View view) {
        mp.stop();
    }

    public void download(View view) {
        String url = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcHdGWkd6UE16Y0k";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
