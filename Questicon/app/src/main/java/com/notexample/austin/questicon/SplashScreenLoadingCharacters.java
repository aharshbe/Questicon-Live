package com.notexample.austin.questicon;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenLoadingCharacters extends AppCompatActivity {

    ImageView icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_loading_characters);

        icon = (ImageView) findViewById(R.id.splashCharacters);
        icon.setBackgroundResource(R.drawable.character_animation);
        AnimationDrawable gyroAnimation = (AnimationDrawable) icon.getBackground();
        gyroAnimation.start();




        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(2 * 1000);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), HorADetailView.class);
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
