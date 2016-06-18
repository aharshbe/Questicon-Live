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
    private String url, url2;
    private Spinner spinner;
    private SeekBar seekBar;
    private double timeStart = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime = 2000;
    private Handler durationHandler = new Handler();
    final int mySong[] = {0, 0, R.raw.song1, R.raw.song2,R.raw.song3, R.raw.song4,
            R.raw.song5, R.raw.song6,R.raw.song7, R.raw.song8,
            R.raw.song9, R.raw.song10,R.raw.song11, R.raw.song12,
            R.raw.song13, R.raw.song14,R.raw.song15, R.raw.song16,
            R.raw.song17, R.raw.song18,R.raw.song19, R.raw.song20,
            R.raw.song21, R.raw.song22,R.raw.song23, R.raw.song24,
            R.raw.song25, R.raw.song26,R.raw.song27, R.raw.song28,
            R.raw.song29, R.raw.song30};
    int currentSongIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


//        songName = (TextView) findViewById(R.id.songName);
        spinner = (Spinner) findViewById(R.id.spinner);
        songDuration = (TextView) findViewById(R.id.songDuration);
        mediaPlayer = MediaPlayer.create(this, mySong[2]);
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
        url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url2));
        startActivity(i);

    }

    public void addItemsOnSpinner2() {

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Please choose a song to play!");
        list.add(":-)");
        list.add("Legends of Azeroth");
        list.add("The Shaping of the World");
        list.add("Legacy");
        list.add("Song of Elune");
        list.add("Echoes of the Past");
        list.add("A Call to Arms");
        list.add("Seasons of War");
        list.add("Stormwind");
        list.add("Orgrimmar");
        list.add("The Undercity");
        list.add("Thunder Bluff");
        list.add("Darnassus");
        list.add("Ironforge");
        list.add("Elwynn Forest");
        list.add("Duskwood");
        list.add("Dun Morogh");
        list.add("Burning Steppes");
        list.add("Shimmering Flats");
        list.add("Felwood");
        list.add("Stranglethorn Vale");
        list.add("Tanaris");
        list.add("Teldrassil");
        list.add("Tavern");
        list.add("Moonfall");
        list.add("Ruins");
        list.add("Temple");
        list.add("Lurking");
        list.add("Sacred");
        list.add("Graveyard");
        list.add("War");


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

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();

            switch (pos){
                case 0:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                    break;
                case 1:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                case 2:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;

                    break;
                case 3:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[3]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;

                    break;
                case 4:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[4]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 5:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[5]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 6:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[6]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 7:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[7]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 8:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[8]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 9:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[9]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 10:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[10]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 11:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[11]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 12:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[12]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJYTNKdVllWHhkZlE";
                    url = url2;
                    break;
                case 13:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[13]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 14:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[14]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;

                    break;
                case 15:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[15]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 16:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[16]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 17:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[17]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 18:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[18]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 19:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[19]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 20:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[20]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 21:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[21]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 22:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[22]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 23:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[23]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJYTNKdVllWHhkZlE";
                    url = url2;

                    break;
                case 24:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[24]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;

                    break;
                case 25:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[25]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;

                    break;
                case 26:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[26]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 27:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[27]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 28:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[28]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 29:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[29]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 30:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[30]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 31:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[31]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                case 32:
                    Toast.makeText(MusicActivity.this, "Media Player for song: " + parent.getItemAtPosition(pos).toString() + "created.", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[32]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;


            }
        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}