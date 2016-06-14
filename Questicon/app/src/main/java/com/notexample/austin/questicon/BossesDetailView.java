package com.notexample.austin.questicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BossesDetailView extends AppCompatActivity {

    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosses_detail_view);

        desc = (TextView) findViewById(R.id.bossDescriptionDetail);

        final String description = getIntent().getStringExtra("des");

        desc.setText(description);


    }
}
