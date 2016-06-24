package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenMain extends AppCompatActivity {

    ImageView icon;
    TextView urdaily, welcome, to, news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_main);

        Typeface font = Typeface.createFromAsset(getAssets(), "wowfont.ttf");

//        background2 = (ImageView) findViewById(R.id.splash);
        icon = (ImageView) findViewById(R.id.icon);
        welcome = (TextView) findViewById(R.id.Welcome);
        welcome.setTypeface(font);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation3.setDuration(2600);
        welcome.setAnimation(animation3);
        to = (TextView) findViewById(R.id.to);
        to.setTypeface(font);
        news = (TextView) findViewById(R.id.newhag);
        news.setTypeface(font);
        urdaily = (TextView) findViewById(R.id.your);
        urdaily.setTypeface(font);
        Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
        animation6.setDuration(2700);
        urdaily.setAnimation(animation6);



//        background2 = (ImageView) findViewById(R.id.splash);
        icon.setBackgroundResource(R.drawable.gyro_animation);
        AnimationDrawable gyroAnimation = (AnimationDrawable) icon.getBackground();
        gyroAnimation.start();




        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation.setDuration(1000);

//        background2.setAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        animation2.setDuration(2000);

        icon.setAnimation(animation2);



        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
        animation4.setDuration(2500);

        to.setAnimation(animation4);

        Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation5.setDuration(2200);

        news.setAnimation(animation5);
//






        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds

                    sleep(4  * 1000);


                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), NavD.class);
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
