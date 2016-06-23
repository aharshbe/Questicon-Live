package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenMain extends AppCompatActivity {

    ImageView background2, icon;
    TextView welcome, to, news, urdaily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_main);

        background2 = (ImageView) findViewById(R.id.splash);
        icon = (ImageView) findViewById(R.id.iconforanim);
        welcome = (TextView) findViewById(R.id.Welcome);
        to = (TextView) findViewById(R.id.to);
        news = (TextView) findViewById(R.id.newhag);
        urdaily = (TextView) findViewById(R.id.your);






        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation.setDuration(1000);

        background2.setAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in);
        animation2.setDuration(2000);

        icon.setAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation3.setDuration(2600);

        welcome.setAnimation(animation3);

        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
        animation4.setDuration(2500);

        to.setAnimation(animation4);

        Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left);
        animation5.setDuration(2200);

        news.setAnimation(animation5);

        Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_out_right);
        animation6.setDuration(2700);

        urdaily.setAnimation(animation6);






        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(3 * 1000);

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

    public void WelcomeDiaglogue() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setIcon(R.mipmap.ic_launcher_questicon);
        builder2.setMessage("Welcome to news hag! Your source for daily news!");
        builder2.setCancelable(true);

        builder2.setPositiveButton(
                "Thanks!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });

        AlertDialog alert12 = builder2.create();
        alert12.show();
    }

}
