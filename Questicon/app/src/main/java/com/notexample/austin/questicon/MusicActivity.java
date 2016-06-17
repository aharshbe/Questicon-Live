package com.notexample.austin.questicon;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MusicActivity extends ActionBarActivity {
    private MediaPlayer mediaPlayer, mediaPlayer2;
    private TextView songDuration;
    private TextView songName;
    private Spinner spinner;
    private SeekBar seekBar;
    private double timeStart = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime = 2000;
    private Handler durationHandler = new Handler();
    final int mySong[] = {R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4,
            R.raw.song5, R.raw.song6, R.raw.song7, R.raw.song8,
            R.raw.song9, R.raw.song10, R.raw.song11, R.raw.song12, R.raw.song13,
            R.raw.song14, R.raw.song16, R.raw.song17, R.raw.song18, R.raw.song19, R.raw.song20,
            R.raw.song21, R.raw.song22, R.raw.song23, R.raw.song24, R.raw.song25, R.raw.song25,
            R.raw.song26, R.raw.song27, R.raw.song28, R.raw.song29, R.raw.song30};

    int currentSongIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


//        songName = (TextView) findViewById(R.id.songName);
        spinner = (Spinner) findViewById(R.id.spinner);
        songDuration = (TextView) findViewById(R.id.songDuration);
        mediaPlayer = MediaPlayer.create(this, mySong[0]);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
//        songName.setText("Song.mp3");
        seekBar.setMax((int) finalTime);
        seekBar.setClickable(false);
        addItemsOnSpinner2();
        addListenerOnSpinnerItemSelection();



    }

    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            timeStart = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int) timeStart);
            double timeRemaining = finalTime - timeStart;
            songDuration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
            durationHandler.postDelayed(this, 100);
        }
    };

    public void play(View view) {


        mediaPlayer.start();
        timeStart = mediaPlayer.getCurrentPosition();
        seekBar.setProgress((int) timeStart);
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }

    public void pause(View view) {
        mediaPlayer.pause();
    }

    public void forward(View view) {


        if ((timeStart + forwardTime) <= finalTime) {
            timeStart = timeStart - backwardTime;
            mediaPlayer.seekTo((int) timeStart);

        }
    }

    public void backforward(View view) {
        //check if we can go back at backwardTime seconds after song starts
        if ((timeStart - backwardTime) > 0) {
            timeStart = timeStart - backwardTime;
            mediaPlayer.seekTo((int) timeStart);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickingSave(View view) {

    }

    public void addItemsOnSpinner2() {

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("The Shaping of the World");
        list.add("Legacy");
        list.add("Song of Elune");
        list.add("Echoes of the Past");
        list.add("A Call to Arms");
        list.add("Seasons of War");
        list.add("Stormwind");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();

            switch (pos){
                case 0:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[0]);
                    break;
                case 1:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[1]);
                    break;
                case 2:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                    break;
                case 3:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[3]);
                    break;
                case 4:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[4]);
                    break;
                case 5:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[5]);
                    break;
                case 6:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[6]);
                    break;


            }
        }




        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}