package com.notexample.austin.questicon;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class WallpaperAcitivty extends AppCompatActivity  {
    ImageView im;
    private String url, url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_acitivty);


        im = (ImageView) findViewById(R.id.selected);
        im.setImageResource(R.drawable.wallpaperhd);
        url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcmtCbktHOFBTZWc";




    }


    public void biggerView(View v) {
        im = (ImageView) findViewById(R.id.selected);


        switch (v.getId()) {
            case R.id.image1:
                im.setImageResource(R.drawable.w1);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJVjlOUFZDYVRKLUk";
                break;
            case R.id.image2:
                im.setImageResource(R.drawable.w2);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJalhKVE1wZmczZGs";
                break;
            case R.id.image3:
                im.setImageResource(R.drawable.w3);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJZWFFTmNzMzQ0UlU";
                break;
            case R.id.image4:
                im.setImageResource(R.drawable.w4);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJWnpmUWxROF9TNUU";
                break;
            case R.id.image5:
                im.setImageResource(R.drawable.w5);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJOER2RTFJQVRDRE0";
                break;
            case R.id.image6:
                im.setImageResource(R.drawable.w6);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcUhxeGswMHdnaEU";
                break;
            case R.id.image7:
                im.setImageResource(R.drawable.w7);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcjgzOEdNTXB4aXc";
                break;
            case R.id.image8:
                im.setImageResource(R.drawable.w8);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJU0VFa3lBcVRwMnc";
                break;
            case R.id.image9:
                im.setImageResource(R.drawable.w9);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJbEFCOF9XWmc2Uzg";
                break;
            case R.id.image10:
                im.setImageResource(R.drawable.w10);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJSjZPWmFWLVlRTHM";
                break;
            case R.id.image11:
                im.setImageResource(R.drawable.w11);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcExDSjFJQXhaRFk";
                break;
            case R.id.image12:
                im.setImageResource(R.drawable.w12);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJY1REMUdxV0lVQlE";
                break;
            case R.id.image13:
                im.setImageResource(R.drawable.w13);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJc2dvVzN2TWRQREk";
                break;
            case R.id.image14:
                im.setImageResource(R.drawable.album);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJXzgxWEx2NTNEVGc";
                break;
            case R.id.image15:
                im.setImageResource(R.drawable.alliancecrest);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJSm5KZjNyTUFhYTA";
                break;
            case R.id.image16:
                im.setImageResource(R.drawable.hordecrest);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJNnVQbjJ0UlRkSHM";
                break;
            case R.id.image17:
                im.setImageResource(R.drawable.wow1);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJX1VfVEJFYTFMWWs";
                break;
            case R.id.image18:
                im.setImageResource(R.drawable.wow2);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJaWxpVURxV0ZObnM";
                break;
            case R.id.image19:
                im.setImageResource(R.drawable.wow3);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJbXVXcnhvZDVSU3M";
                break;
            case R.id.image20:
                im.setImageResource(R.drawable.wow4);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJUnlQbHBKRDBUZjA";
                break;
            case R.id.image21:
                im.setImageResource(R.drawable.i9);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJbElKa3JiWG9jLVk";
                break;
            case R.id.image22:
                im.setImageResource(R.drawable.i10);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJUnliaTBRbWptTzg";
                break;
            case R.id.image23:
                im.setImageResource(R.drawable.i11);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJMkxieWt4VGgyV2s";
                break;
            case R.id.image24:
                im.setImageResource(R.drawable.i12);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJRUJJc2RId0ZlUHM";
                break;
            case R.id.image25:
                im.setImageResource(R.drawable.i13);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJdGV0M3NoWWpoc1k";
                break;
            case R.id.image26:
                im.setImageResource(R.drawable.i14);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJaFVUNmJHWE14eFE";
                break;
            case R.id.image27:
                im.setImageResource(R.drawable.i15);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJb0RHUU5LdTRfeUk";
                break;
            case R.id.image28:
                im.setImageResource(R.drawable.i16);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJODVNdVJSb2x2MTQ";
                break;
            default:
                im.setImageResource(R.drawable.wallpaperhd);
                url2 = "https://docs.google.com/uc?export=download&id=0B7NezlAJoyHJcmtCbktHOFBTZWc";
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void clickingSave(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url2));
        startActivity(i);
    }



}

