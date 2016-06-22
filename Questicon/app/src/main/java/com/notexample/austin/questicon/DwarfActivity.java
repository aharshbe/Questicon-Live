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

public class DwarfActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_dwarf);

        songDuration = (TextView) findViewById(R.id.undeadNarration);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.dwarfnarration);


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

    public void clickingStoneForm(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_stoneform);
        builder1.setTitle("STONEFORM");
        builder1.setMessage("Dwarves can temporarily turn to living stone, neutralizing any poisons, diseases, and bleeding wounds, and adding natural armor.");
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

    public void clickingFrostRes(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_frostresist);
        builder1.setTitle("FROST RESISTANCE");
        builder1.setMessage("Ironforge dwarves have a natural resistance to Frost magic.");
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

    public void clickingExporer(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_exporer);
        builder1.setTitle("EXPLORER");
        builder1.setMessage("Dwarves receive a skill bonus to archaeology and are able to survey faster than other races.");
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

    public void clickingMightof(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_mightofmountain);
        builder1.setTitle("MIGHT OF THE MOUNTAIN");
        builder1.setMessage("Dwarves battle with powerful intent and gain a bonus to critical strikes.");
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
