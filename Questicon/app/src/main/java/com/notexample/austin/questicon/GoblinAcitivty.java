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

public class GoblinAcitivty extends AppCompatActivity {

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
        setContentView(R.layout.activity_goblin_acitivty);

        songDuration = (TextView) findViewById(R.id.undeadNarration);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.goblinnarration);


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

    public void clickingRocketJump(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_rocketjump);
        builder1.setTitle("ROCKET JUMP");
        builder1.setMessage("Goblins can use their trusty (well, relatively speaking) rocket belts to launch themselves over short distances.");

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

    public void clickingRocketBar(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_rocketbar);
        builder1.setTitle("ROCKET BARRAGE");
        builder1.setMessage("The rocket belt can also launch rockets at an enemy, causing fire damage to the target.");

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

    public void clickingHobGoblin(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_hobgob);
        builder1.setTitle("PACK HOBGOBLIN");
        builder1.setMessage("Goblins can access their bank vault from anywhere with the help of a trusted friend.");

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

    public void clickingDeals(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_extradeals);
        builder1.setTitle("BEST DEALS ANYWHERE");
        builder1.setMessage("Wheeling and dealing is second nature to goblins, and they always receive a discount from vendors.");

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

    public void clickingTimeisMoney(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_timeismoney);
        builder1.setTitle("TIME IS MONEY");
        builder1.setMessage("Goblins cash in on a bonus to haste.");

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

    public void clickingChemisry(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_chemistry);
        builder1.setTitle("BETTER LIVING THROUGH CHEMISTRY");
        builder1.setMessage("Goblins have a natural affinity for fragile, hazardous materials and receive a bonus to Alchemy.");

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
