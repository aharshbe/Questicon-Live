package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DunegonDetailView extends AppCompatActivity {

    WebView bossesName;
    String URLString, URLString2, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dunegon_detail_view);



        bossesName = (WebView) findViewById(R.id.webViewDungeonDetail);


         name = getIntent().getStringExtra("name");


        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        bossesName.getSettings().setBuiltInZoomControls(true);
        bossesName.getSettings().setSupportZoom(true);
        bossesName.getSettings().getLoadsImagesAutomatically();
        bossesName.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        bossesName.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Loading dungeon info, just one second more...");
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });

        bossesName.loadUrl("http://wow.gamepedia.com/" + name);
        URLString = "http://wow.gamepedia.com/" + name;
        URLString2 = URLString.replaceAll("\\s+", "_");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share, menu);
        return true;
    }
    public void clickingShare(MenuItem item) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, URLString2);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }
}
