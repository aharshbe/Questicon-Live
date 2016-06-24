package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView charsearch, chars, bosses, dungeons, mounts, pets, lore, gallery, music, share;
    FrameLayout charsearchframe;

//    ImageView gyro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkFirstRun();
        NOTIFICATIONBox();

        Typeface font = Typeface.createFromAsset(getAssets(), "wowfont.ttf");


        charsearch = (TextView) findViewById(R.id.charactersearch);
        charsearch.setTypeface(font);
        chars = (TextView) findViewById(R.id.characterinfo);
        chars.setTypeface(font);
        bosses = (TextView) findViewById(R.id.bossestextview);
        bosses.setTypeface(font);
        dungeons = (TextView) findViewById(R.id.dungeonstextview);
        dungeons.setTypeface(font);
        mounts = (TextView) findViewById(R.id.mountstextview);
        mounts.setTypeface(font);
        pets = (TextView) findViewById(R.id.petstextview);
        pets.setTypeface(font);
        lore = (TextView) findViewById(R.id.loretextview);
        lore.setTypeface(font);
        gallery = (TextView) findViewById(R.id.gallerytextview);
        gallery.setTypeface(font);
        music= (TextView) findViewById(R.id.musictextview);
        music.setTypeface(font);
        share = (TextView) findViewById(R.id.sharetextview);
        share.setTypeface(font);





//        gyro = (ImageView) findViewById(R.id.gyro);
//        gyro.setBackgroundResource(R.drawable.loading_tenticles_annimation);
//        AnimationDrawable gyroAnimation = (AnimationDrawable) gyro.getBackground();
//        gyroAnimation.start();





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

        } else if (id == R.id.nav_Music) {

        } else if (id == R.id.nav_Gallery) {


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


    public void clickingLore(MenuItem item) {
        Intent intent = new Intent(NavD.this, LoreActivity.class);
        startActivity(intent);
    }


    public void clickingGallery(MenuItem item) {
        Intent intent = new Intent(NavD.this, WallpaperAcitivty.class);
        startActivity(intent);
    }


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
    public void NOTIFICATIONBox() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //If there is internet connection then the user will be presented with a notification that displays the top story
        if (networkInfo != null && networkInfo.isConnected()) {

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(6);


        } else {
            NoInternetDialogue();

//            Intent intent = new Intent(NavD.this, MainActivity.class);
            Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);

//            PendingIntent pendingIntent = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent, 0);
            PendingIntent pendingIntent1 = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent1, 0);


            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NavD.this);
            mBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
            mBuilder.setContentTitle("No internet connection!");
            Notification notification = mBuilder.build();
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            mBuilder.setSound(notification.sound = Uri.parse("android.resource://"
                    + this.getPackageName() + "/" + R.raw.notif));
            mBuilder.setVibrate(pattern);
            mBuilder.setLights(Color.RED, 500, 500);
            mBuilder.setStyle(new NotificationCompat.InboxStyle());
            mBuilder.setContentText("To use the app, please enable WIFI, Thanks!");
            mBuilder.setContentIntent(pendingIntent1);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigTextStyle);
            mBuilder.addAction(android.R.drawable.ic_menu_info_details, "Connect WIFI", pendingIntent1);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(6, bigTextStyle.build());
        }


    }


    public void NoInternetDialogue() {
        AlertDialog.Builder builder7 = new AlertDialog.Builder(this);
        builder7.setIcon(R.mipmap.ic_main_icon_questicon);
        builder7.setMessage("No internet connection, please click below to enable connection!" + "\n" + "\n" + "-Sincerely, your developers");
        builder7.setCancelable(true);

        builder7.setPositiveButton(
                "Go to connection settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent1);


                        return;
                    }
                });

        builder7.setNegativeButton(
                "I'm alright",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(NavD.this, "Totally get it, but be advised unfortunately Questicons functionality will be greatly limited!", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder7.create();
        alert11.show();

    }


    public void clickingCharSearch(View view) {
        Intent intent = new Intent(NavD.this, CharacterActivity.class);
        startActivity(intent);
    }

    public void clickingCharInfo(View view) {
        Intent intent = new Intent(NavD.this, SplashScreenLoadingCharacters.class);
        startActivity(intent);
    }

    public void clickingBossesAc(View view) {
        Intent intent = new Intent(NavD.this, BossesActivity.class);
        startActivity(intent);
    }

    public void clickingDungeonsAc(View view) {
        Intent intent = new Intent(NavD.this, DungeonActivity.class);
        startActivity(intent);
    }
    public void clickingMountsAc(View view) {
        Intent intent = new Intent(NavD.this, MountsActivity.class);
        startActivity(intent);
    }

    public void clickingPetsAc(View view) {
        Intent intent = new Intent(NavD.this, PetsActivity.class);
        startActivity(intent);
    }

    public void clickingLoreAc(View view) {
        Intent intent = new Intent(NavD.this, LoreActivity.class);
        startActivity(intent);
    }

    public void clickingGalleryAc(View view) {
        Intent intent = new Intent(NavD.this, WallpaperAcitivty.class);
        startActivity(intent);
    }

    public void clickingMusicAc(View view) {
        Intent intent = new Intent(NavD.this, MusicActivity.class);
        startActivity(intent);
    }

    public void clickingShare(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://github.com/aharshbe/Questicon");
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }

    public void clickingShareNav(MenuItem item) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://github.com/aharshbe/Questicon");
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }
}
