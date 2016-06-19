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
import android.widget.ImageView;
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
    private ImageView mp3Icon;
    private TextView songDuration;
    private TextView songName;
    private String url, url2;
    private int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30;
    private Spinner spinner;
    private SeekBar seekBar;
    private double timeStart = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime = 2000;
    private Handler durationHandler = new Handler();
    final int mySong[] = {0, 0, R.raw.song1, R.raw.song2, R.raw.song3, R.raw.song4,
            R.raw.song5, R.raw.song6, R.raw.song7, R.raw.song8,
            R.raw.song9, R.raw.song10, R.raw.song11, R.raw.song12,
            R.raw.song13, R.raw.song14, R.raw.song15, R.raw.song16,
            R.raw.song17, R.raw.song18, R.raw.song19, R.raw.song20,
            R.raw.song21, R.raw.song22, R.raw.song23, R.raw.song24,
            R.raw.song25, R.raw.song26, R.raw.song27, R.raw.song28,
            R.raw.song29, R.raw.song30};
    int currentSongIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


//        songName = (TextView) findViewById(R.id.songName);
        mp3Icon = (ImageView) findViewById(R.id.mp3Icon);
        i1 = getResources().getIdentifier(String.valueOf(R.drawable.i1), null, null);
        i2 = getResources().getIdentifier(String.valueOf(R.drawable.i2), null, null);
        i3 = getResources().getIdentifier(String.valueOf(R.drawable.i3), null, null);
        i4 = getResources().getIdentifier(String.valueOf(R.drawable.i4), null, null);
        i5 = getResources().getIdentifier(String.valueOf(R.drawable.i5), null, null);
        i6 = getResources().getIdentifier(String.valueOf(R.drawable.i6), null, null);
        i7 = getResources().getIdentifier(String.valueOf(R.drawable.i8), null, null);
        i8 = getResources().getIdentifier(String.valueOf(R.drawable.i9), null, null);
        i9 = getResources().getIdentifier(String.valueOf(R.drawable.i10), null, null);
        i10 = getResources().getIdentifier(String.valueOf(R.drawable.i11), null, null);
        i11 = getResources().getIdentifier(String.valueOf(R.drawable.i12), null, null);
        i12 = getResources().getIdentifier(String.valueOf(R.drawable.i13), null, null);
        i13 = getResources().getIdentifier(String.valueOf(R.drawable.i14), null, null);
        i14 = getResources().getIdentifier(String.valueOf(R.drawable.i16), null, null);
        i15 = getResources().getIdentifier(String.valueOf(R.drawable.i17), null, null);
        i16 = getResources().getIdentifier(String.valueOf(R.drawable.i18), null, null);
        i17 = getResources().getIdentifier(String.valueOf(R.drawable.i19), null, null);
        i18 = getResources().getIdentifier(String.valueOf(R.drawable.i20), null, null);
        i19 = getResources().getIdentifier(String.valueOf(R.drawable.i21), null, null);
        i20 = getResources().getIdentifier(String.valueOf(R.drawable.i22), null, null);
        i21 = getResources().getIdentifier(String.valueOf(R.drawable.i23), null, null);
        i22 = getResources().getIdentifier(String.valueOf(R.drawable.i24), null, null);
        i23 = getResources().getIdentifier(String.valueOf(R.drawable.i25), null, null);
        i24 = getResources().getIdentifier(String.valueOf(R.drawable.i26), null, null);
        i25 = getResources().getIdentifier(String.valueOf(R.drawable.i27), null, null);
        i26 = getResources().getIdentifier(String.valueOf(R.drawable.i28), null, null);
        i27 = getResources().getIdentifier(String.valueOf(R.drawable.i29), null, null);
        i28 = getResources().getIdentifier(String.valueOf(R.drawable.wifi), null, null);
        i29 = getResources().getIdentifier(String.valueOf(R.drawable.album), null, null);
        i30 = getResources().getIdentifier(String.valueOf(R.drawable.album), null, null);




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


            switch (pos) {
                case 0:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
//                    mp3Icon.setImageResource(i30);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJeTNUdVd4QzdTb2c";
                    url = url2;
                    break;
                case 1:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
//                    mp3Icon.setImageResource(i30);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJeTNUdVd4QzdTb2c";
                    url = url2;
                    break;
                case 2:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i1);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJeTNUdVd4QzdTb2c";
                    url = url2;
                    break;
                case 3:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[3]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i2);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJc3h4TmQ2ZmJZWW8";
                    url = url2;
                    break;
                case 4:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[4]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i3);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJYzBoSXVtRDRPQ2c";
                    url = url2;
                    break;
                case 5:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[5]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i4);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcUp5YkZIanF6RlU";
                    url = url2;
                    break;

                case 6:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[6]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i5);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJeGVOaXR0ZHRzZlk";
                    url = url2;
                    break;
                case 7:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[7]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i6);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJSHEtd3pQYXNHZlE";
                    url = url2;
                    break;
                case 8:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[8]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i6);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJVWh3bExLN016UHc";
                    url = url2;
                    break;
                case 9:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[9]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i7);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJNTdaWl9uZlFxUXc";
                    url = url2;
                    break;
                case 10:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[10]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i8);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJNGRZUjAxUjlBTmM";
                    url = url2;
                    break;
                case 11:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[11]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i9);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJQ3hBV0oxNkJWVFU";
                    url = url2;
                    break;
                case 12:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[12]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i10);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJNUg1VTZWWFJuTTA";
                    url = url2;
                    break;
                case 13:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[13]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i11);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJVUl2OW4wQkJpYU0";
                    url = url2;
                    break;
                case 14:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[14]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i12);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJQzFydGlkNGJuajg";
                    url = url2;

                    break;
                case 15:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[15]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i13);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJY1JuRGV3U0pkdHc";
                    url = url2;
                    break;
                case 16:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[16]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i14);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJZXVfRTl5bGFKTHM";
                    url = url2;
                    break;
                case 17:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[17]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i15);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJOTktb1NjeVhDREE";
                    url = url2;
                    break;
                case 18:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[18]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i15);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJVUJ6VVFfQlRuZUE";
                    url = url2;
                    break;
                case 19:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[19]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i16);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJaFVDNlRfS2cwcUE";
                    url = url2;
                    break;
                case 20:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[20]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i17);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJQ1RmcThucXZ0Qjg";
                    url = url2;
                    break;
                case 21:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[21]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i18);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJZ0FJal9FNFdlYnc";
                    url = url2;
                    break;
                case 22:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[22]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i19);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJWFlwR2ZpV3g4c1U";
                    url = url2;
                    break;
                case 23:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[23]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i20);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJYVZFZWJ4RklKNk0";
                    url = url2;

                    break;
                case 24:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[24]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i21);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJZU9GaG16ajNLUnc";
                    url = url2;

                    break;
                case 25:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[25]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i22);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJc09wNDRwT2pNQjQ";
                    url = url2;

                    break;
                case 26:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[26]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i23);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJVnE0VHBscXg5NzQ";
                    url = url2;
                    break;
                case 27:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[27]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i24);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJQzN1SHhpWHd1c2s";
                    url = url2;
                    break;
                case 28:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[28]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i25);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJMzN4NUUxMjJGOVk";
                    url = url2;
                    break;
                case 29:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[29]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i26);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJblg3Vm1QckZEdjQ";
                    url = url2;
                    break;
                case 30:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[30]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i27);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJOXY1YjkxZFFGbVk";
                    url = url2;
                    break;
                case 31:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[31]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i28);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJRXJmUTRoRjlKdG8";
                    url = url2;
                    break;
                //stopped here
                case 32:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[32]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
//                    mp3Icon.setImageResource(i30);
                    url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJLTdOcW1jZjdUXzQ";
                    url = url2;
                    break;
                default:
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(MusicActivity.this, mySong[2]);
                    timeStart = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress((int) timeStart);
                    durationHandler.postDelayed(updateSeekBarTime, 100);
                    url2 = "http://www.worldofwarcraft.com";
//                    mp3Icon.setImageResource(i30);
                    url = url2;
                    break;



            }
        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}