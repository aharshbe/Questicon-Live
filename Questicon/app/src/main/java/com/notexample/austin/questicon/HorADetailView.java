package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HorADetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_adetail_view);
    }

    public void clickingInfoAlliance(View view) {
        AllianceInfoDialogue();
    }

    public void clickingInfoHorde(View view) {
        HordeInfoDialogue();
    }

    public void clickingHordeSelect(View view) {
        Intent intent = new Intent(HorADetailView.this, AllianceSelectActivity.class);
        startActivity(intent);
    }

    public void clickingAllianceSelect(View view) {
        Intent intent = new Intent(HorADetailView.this, HordeSelectActivity.class);
        startActivity(intent);
    }

    public void AllianceInfoDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Humans, night elves, dwarves, gnomes, draenei, worgen, and most recently, pandaren (Tushui) make up the illustrious Alliance.'\n" +
                "Proud and noble, courageous and wise, these races work together to preserve order in Azeroth. The Alliance is driven by honor and tradition. Its rulers are champions of justice, hope, knowledge, and faith.\n" +
                "In a time when chaos and uncertainty reign, the Alliance remains steadfast in its determination to bring light to the darkest corners of the world.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();


                        return;
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    public void HordeInfoDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("The Horde is made up of Orcs, Forsaken, Tauren, Trolls, Blood Elves, Goblins, and most recently, Pandaren (Huojin). Misunderstood and cast aside, these diverse and powerful races strive to overcome their differences and unite as one in order to win freedom for their people and prosper in a land that has come to hate them.\n" +
                "In the Horde, action and strength are valued above diplomacy, and its leaders earn respect by the blade, wasting no time with politics. The brutality of the Horde's champions is focused, giving a voice to those who fight for survival.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
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
