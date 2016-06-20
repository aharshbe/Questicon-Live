package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AllianceSelectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alliance_select);
    }


    public void clickingFramePandarin(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_launcher_questicon);
        builder1.setTitle("Pandaren: The Gentle");
        builder1.setMessage("Couched in myth and legend, rarely seen and even more rarely understood, the enigmatic pandaren have long been a mystery to the other races of Azeroth. The noble history of the pandaren people stretches back thousands of years, well before the empires of man and before even the sundering of the world.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Select Pandarin",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(AllianceSelectActivity.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        builder1.setNegativeButton(
                "Further info",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("http://us.battle.net/wow/en/game/race/pandaren"));
                        startActivity(browserIntent);

                        return;
                    }
                });

        builder1.setNeutralButton(
                "Pandarin Video",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent.setData(Uri.parse("https://www.youtube.com/watch?v=UQh94o_Ph_I"));
                        startActivity(browserIntent);

                        return;
                    }
                });


        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
