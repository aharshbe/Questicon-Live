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

public class TrollAcitivty extends AppCompatActivity {
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

        }catch (IllegalStateException i){
            i.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troll_acitivty);

        songDuration = (TextView) findViewById(R.id.undeadNarration);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.trollstarting);


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

    public void clickingVoodoo(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_vodoo);
        builder1.setTitle("DA VOODOO SHUFFLE");
        builder1.setMessage("Thanks to their impressive legerity, trolls are less affected by movement impairing effects than other races.");
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

    public void clickingRegeneration(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_regeneration);
        builder1.setTitle("REGENERATION");
        builder1.setMessage("Trolls have a natural healing factor that constantly replenishes their health, even when they are engaged in combat.");
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

    public void clickingBeastSlay(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_bestslay);
        builder1.setTitle("BEAST SLAYING");
        builder1.setMessage("Trolls hunt with a keen awareness and gain additional experience from killing beasts.");
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

    public void clickingRanged(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_ranged);
        builder1.setTitle("THROWING WEAPON AND BOW SPECIALIZATION");
        builder1.setMessage("Trolls receive bonuses when using their favored weapons.");
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

    public void clickingBerserking(View view) {
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_berserking);
        builder1.setTitle("BERSERKING");
        builder1.setMessage("Trolls can launch themselves into a frenzy, increasing their attack and casting speed for a short time.");
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
