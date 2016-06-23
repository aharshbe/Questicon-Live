package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class NavD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    ImageView gyro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkFirstRun();


<<<<<<< HEAD
=======

>>>>>>> splash
//        gyro = (ImageView) findViewById(R.id.gyro);
//        gyro.setBackgroundResource(R.drawable.loading_tenticles_annimation);
//        AnimationDrawable gyroAnimation = (AnimationDrawable) gyro.getBackground();
//        gyroAnimation.start();
<<<<<<< HEAD
=======



>>>>>>> splash


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_d, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_char) {
            // Handle the camera action
        } else if (id == R.id.nav_bosses) {

        } else if (id == R.id.nav_quest) {

        } else if (id == R.id.nav_mounts) {

        } else if (id == R.id.nav_items) {

        } else if (id == R.id.nav_Lore) {

<<<<<<< HEAD
        } else if (id == R.id.nav_Media) {
=======
        } else if (id == R.id.nav_Music) {

        } else if (id == R.id.nav_Gallery) {
>>>>>>> splash

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickingCharacter(MenuItem item) {
        Intent intent = new Intent(NavD.this, CharacterActivity.class);
        startActivity(intent);
    }

    public void clickingBosses(MenuItem item) {
        Intent intent = new Intent(NavD.this, BossesActivity.class);
        startActivity(intent);
    }

    public void clickingDungeons(MenuItem item) {
        Intent intent = new Intent(NavD.this, DungeonActivity.class);
        startActivity(intent);
    }

    public void clickingMounts(MenuItem item) {
        Intent intent = new Intent(NavD.this, MountsActivity.class);
        startActivity(intent);
    }

    public void clickingPets(MenuItem item) {
        Intent intent = new Intent(NavD.this, PetsActivity.class);
        startActivity(intent);
    }

    public void clickingMedia(MenuItem item) {
        Intent intent = new Intent(NavD.this, MediaAcitvity.class);
        startActivity(intent);
    }


    public void clickingLore(MenuItem item) {
        Intent intent = new Intent(NavD.this, LoreActivity.class);
        startActivity(intent);
    }

<<<<<<< HEAD
=======
    public void clickingGallery(MenuItem item) {
        Intent intent = new Intent(NavD.this, WallpaperAcitivty.class);
        startActivity(intent);
    }
>>>>>>> splash

    public void clickingMusic(MenuItem item) {
        Intent intent = new Intent(NavD.this, MusicActivity.class);
        startActivity(intent);
    }



    public void clickingChooser(MenuItem item) {
        Intent intent = new Intent(NavD.this, SplashScreenLoadingCharacters.class);
        startActivity(intent);
    }

    public void WelcomeDiaglogue() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Dear WoW player...");
        builder2.setIcon(R.mipmap.ic_launcher_questicon);
        builder2.setMessage("Welcome to Questicon: Your World of Warcraft Companion \n\n To get started, swipe from the left, there you'll have access to all the bosses, characters and dungeons WoW has to offer. \n\nFeel free to checkout media for some fun stuff too!");
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

<<<<<<< HEAD

=======
    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {

            WelcomeDiaglogue();


            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }


    public void clickingInfo(MenuItem item) {
        WelcomeDiaglogue();
    }
>>>>>>> splash
}
