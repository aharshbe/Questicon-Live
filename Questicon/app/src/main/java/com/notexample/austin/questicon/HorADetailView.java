package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HorADetailView extends AppCompatActivity {

    TextView horde, alliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_adetail_view);

        Typeface font = Typeface.createFromAsset(getAssets(), "wowfont.ttf");

        checkFirstRun();
        horde = (TextView) findViewById(R.id.thehordetextview);
        horde.setTypeface(font);
        alliance = (TextView) findViewById(R.id.thealliancetextview);
        alliance.setTypeface(font);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return true;
    }



    public void clickingHordeSelect(View view) {
        HordeInfoDialogue();
    }

    public void clickingAllianceSelect(View view) {
        AllianceInfoDialogue();
    }

    public void AllianceInfoDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_alliancecresticon);
        builder1.setTitle("The Alliance");
        builder1.setMessage("Humans, night elves, dwarves, gnomes, draenei, worgen, and most recently, pandaren (Tushui) make up the illustrious Alliance.'\n" +
                "Proud and noble, courageous and wise, these races work together to preserve order in Azeroth. The Alliance is driven by honor and tradition. Its rulers are champions of justice, hope, knowledge, and faith.\n" +
                "In a time when chaos and uncertainty reign, the Alliance remains steadfast in its determination to bring light to the darkest corners of the world.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Still reading...",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();


                        return;
                    }
                });

        builder1.setNegativeButton(
                "I choose The Alliance!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HorADetailView.this, AllianceSelectActivity.class);
                        startActivity(intent);


                        return;
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void HordeInfoDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_hordecresticon);
        builder1.setTitle("The Horde");
        builder1.setMessage("The Horde is made up of Orcs, Forsaken, Tauren, Trolls, Blood Elves, Goblins, and most recently, Pandaren (Huojin). Misunderstood and cast aside, these diverse and powerful races strive to overcome their differences and unite as one in order to win freedom for their people and prosper in a land that has come to hate them.\n" +
                "In the Horde, action and strength are valued above diplomacy, and its leaders earn respect by the blade, wasting no time with politics. The brutality of the Horde's champions is focused, giving a voice to those who fight for survival.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Still reading...",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();


                        return;
                    }
                });
        builder1.setNegativeButton(
                "I choose The Horde!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HorADetailView.this, HordeSelectActivity.class);
                        MediaPlayer mediaPlayer = MediaPlayer.create(HorADetailView.this, R.raw.glorytothehorde );
                        mediaPlayer.start();
                        startActivity(intent);


                        return;
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    public void InfoDiaglogue() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("So you're a little confused...");
        builder2.setIcon(R.mipmap.ic_launcher_questicon);
        builder2.setCancelable(true);
        builder2.setMessage("Select a faction: \n\n There are two factions: The Horde and The Alliance. \n\n To view information about each simply click on it's sigil!");
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
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun3", true);
        if (isFirstRun) {

            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle("Dear WoW player...");
            builder2.setIcon(R.mipmap.ic_launcher_questicon);
            builder2.setCancelable(true);
            builder2.setMessage("Select a faction: \n\n There are two factions: The Horde and The Alliance. \n\n To view information about each simply click on it's sigil!");
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

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun3", false)
                    .apply();
        }
    }

    public void clickingInfo(MenuItem item) {
        InfoDiaglogue();
    }
}
