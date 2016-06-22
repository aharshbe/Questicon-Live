package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class PandarinAllianceActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer2;
    private TextView songDuration;
    private double timeStart = 0, finalTime = 0;
    private int backwardTime = 2000;
    private Handler durationHandler = new Handler();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {

            if (mediaPlayer2.isPlaying() == true) {

                durationHandler.removeCallbacks(updateSeekBarTime);
                mediaPlayer2.stop();
                mediaPlayer2.reset();
                mediaPlayer2.release();

            }

        } catch (IllegalStateException i) {
            i.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pandarin_alliance);

        songDuration = (TextView) findViewById(R.id.undeadNarration);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.pandarinnarration);


    }

    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {

            try {
                timeStart = mediaPlayer2.getCurrentPosition();

            } catch (java.lang.IllegalStateException s) {
                s.printStackTrace();
                timeStart = 0;
            }
            double timeRemaining = finalTime - timeStart;
            songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
            durationHandler.postDelayed(this, 100);


        }
    };

    public void playUndead(View view) {


        mediaPlayer2.start();
        timeStart = mediaPlayer2.getCurrentPosition();
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    public void pauseUndead(View view) {
        mediaPlayer2.pause();
    }


    public void backforwardUndead(View view) {

        if ((timeStart - backwardTime) > 0) {
            timeStart = timeStart - backwardTime;
            mediaPlayer2.seekTo((int) timeStart);
        }
    }

    public void clickingStop(View view) {

        durationHandler.removeCallbacks(updateSeekBarTime);
        mediaPlayer2.stop();
        mediaPlayer2.reset();
        mediaPlayer2.release();
    }

    public void clickingNeutralPandarin(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_pandarinneutral);
        builder1.setTitle("FACTION-NEUTRAL");
        builder1.setMessage("Pandaren may choose to align with either the Alliance or the Horde upon completing their adventures on The Wandering Isle.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingEpicurean(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_epicurean);
        builder1.setTitle("EPICUREAN");
        builder1.setMessage("Your love of food allows you to receive double the stats from Well Fed effects.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingGourmand(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_gourmand);
        builder1.setTitle("GOURMAND");
        builder1.setMessage("Cooking skill increased by 15.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingInnerPeace(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_innerpeace);
        builder1.setTitle("INNER PEACE");
        builder1.setMessage("Your rested experience bonus lasts twice as long.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingBouncy(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_bouncy);
        builder1.setTitle("BOUNCY");
        builder1.setMessage("You take 50% less falling damage.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void clickingQuickPalm(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_quickpalm);
        builder1.setTitle("QUAKING PALM");
        builder1.setMessage("Strikes the target with lightning speed, incapacitating them for 4 seconds.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Cool!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
