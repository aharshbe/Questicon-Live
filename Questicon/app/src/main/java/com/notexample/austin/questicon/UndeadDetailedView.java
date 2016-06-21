package com.notexample.austin.questicon;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UndeadDetailedView extends AppCompatActivity {
    View.OnClickListener mOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undead_detailed_view);

        Snackbar.make(findViewById(android.R.id.content), "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Undo", mOnClickListener)
                .setActionTextColor(Color.RED)
                .show();

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

}
