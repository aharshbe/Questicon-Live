package com.notexample.austin.questicon;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DunegonDetailView extends AppCompatActivity {

    WebView bossesName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dunegon_detail_view);


        bossesName = (WebView) findViewById(R.id.webViewDungeonDetail);


        final String name = getIntent().getStringExtra("name");


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


    }
}
