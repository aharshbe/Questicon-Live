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

public class NightElfActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_night_elf);

        songDuration = (TextView) findViewById(R.id.undeadNarration);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.nightelfnarration);


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

    public void clickingShadowMeld(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_shadowmeld);
        builder1.setTitle("SHADOWMELD");
        builder1.setMessage("Slipping into the shadows and waiting for the right moment to strike is second nature to the elusive night elves.");
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

    public void clickingWisp(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_wisp);
        builder1.setTitle("WISP SPIRIT");
        builder1.setMessage("Fallen night elves assume the form of wisp spirits, which navigate the spirit world much faster than normal spirits.");
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

    public void clickingNatureResist(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_natureresist);
        builder1.setTitle("NATURE RESISTANCE");
        builder1.setMessage("Night elves have a natural resistance to Nature magic.");
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

    public void clickingQuickness(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_quickness);
        builder1.setTitle("QUICKNESS");
        builder1.setMessage("The nimble night elves have a slight chance to completely avoid being hit by melee and ranged attacks.");
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

    public void clickingTouchOfElune(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_touchofelune);
        builder1.setTitle("TOUCH OF ELUNE");
        builder1.setMessage("Night elves are especially attuned to the cycles of the sun and moon and are empowered with a unique benefit at day and night time.");
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
