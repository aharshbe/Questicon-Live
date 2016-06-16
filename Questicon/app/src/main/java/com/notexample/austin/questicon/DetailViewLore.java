package com.notexample.austin.questicon;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailViewLore extends AppCompatActivity {

    WebView videoURL;
    String URLFromIntent, URLString, URLString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view_lore);

        videoURL = (WebView) findViewById(R.id.webViewforyoutubevideo);
        URLFromIntent = getIntent().getStringExtra("urlVideo");


        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        videoURL.getSettings().setBuiltInZoomControls(true);
        videoURL.getSettings().setJavaScriptEnabled(true);
        videoURL.getSettings().setSupportZoom(true);
        videoURL.getSettings().getLoadsImagesAutomatically();
        videoURL.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        videoURL.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Loading video on YouTube info, just one second more...");
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });

        videoURL.loadUrl("https://www.youtube.com/watch?v=" + URLFromIntent);
        URLString = "https://www.youtube.com/watch?v=" + URLFromIntent;
        URLString2 = URLString.replaceAll("\\s+", "_");


    }
}
