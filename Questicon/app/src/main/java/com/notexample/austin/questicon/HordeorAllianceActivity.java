package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HordeorAllianceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hordeor_alliance);
    }

    public void clickingEnterCharacterC(View view) {
        Intent intent = new Intent(HordeorAllianceActivity.this, HorADetailView.class);
        startActivity(intent);
    }
}
