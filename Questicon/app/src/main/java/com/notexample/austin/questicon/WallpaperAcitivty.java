package com.notexample.austin.questicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class WallpaperAcitivty extends AppCompatActivity {
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_acitivty);
    }


    public void biggerView(View v)
    {
        im=(ImageView)findViewById(R.id.selected);

        switch (v.getId())
        {
            case R.id.image1: im.setImageResource(R.drawable.w1);
                break;
            case R.id.image2: im.setImageResource(R.drawable.w2);
                break;
            case R.id.image3: im.setImageResource(R.drawable.w3);
                break;
            case R.id.image4: im.setImageResource(R.drawable.w4);
                break;
            case R.id.image5: im.setImageResource(R.drawable.w5);
                break;
            case R.id.image6: im.setImageResource(R.drawable.w6);
                break;
            case R.id.image7: im.setImageResource(R.drawable.w7);
                break;
            case R.id.image8: im.setImageResource(R.drawable.w8);
                break;
            case R.id.image9: im.setImageResource(R.drawable.w9);
                break;
            case R.id.image10: im.setImageResource(R.drawable.w10);
                break;
            case R.id.image11: im.setImageResource(R.drawable.w11);
                break;
            case R.id.image12: im.setImageResource(R.drawable.w12);
                break;
            case R.id.image13: im.setImageResource(R.drawable.w13);
                break;
            case R.id.image14: im.setImageResource(R.drawable.i1);
                break;
            case R.id.image15: im.setImageResource(R.drawable.i2);
                break;
            case R.id.image16: im.setImageResource(R.drawable.i3);
                break;
            case R.id.image17: im.setImageResource(R.drawable.i4);
                break;
            case R.id.image18: im.setImageResource(R.drawable.i5);
                break;
            case R.id.image19: im.setImageResource(R.drawable.i6);
                break;
            case R.id.image20: im.setImageResource(R.drawable.i8);
                break;
            case R.id.image21: im.setImageResource(R.drawable.i9);
                break;
            case R.id.image22: im.setImageResource(R.drawable.i10);
                break;
            case R.id.image23: im.setImageResource(R.drawable.i11);
                break;
            case R.id.image24: im.setImageResource(R.drawable.i12);
                break;
            case R.id.image25: im.setImageResource(R.drawable.i13);
                break;
            case R.id.image26: im.setImageResource(R.drawable.i14);
                break;
            case R.id.image27: im.setImageResource(R.drawable.i15);
                break;
            case R.id.image28: im.setImageResource(R.drawable.i16);
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

