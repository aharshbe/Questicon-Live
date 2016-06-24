package com.notexample.austin.questicon;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreenDungeons extends AppCompatActivity {

    ImageView icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_dungeons);

        icon = (ImageView) findViewById(R.id.splashCharacters);
        icon.setBackgroundResource(R.drawable.darkportal_animation);
        AnimationDrawable gyroAnimation = (AnimationDrawable) icon.getBackground();
        gyroAnimation.start();




        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(3 * 1000);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), DungeonActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

}
