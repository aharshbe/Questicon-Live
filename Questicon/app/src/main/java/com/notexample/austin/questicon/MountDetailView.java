package com.notexample.austin.questicon;

import android.app.ProgressDialog;
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
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MountDetailView extends AppCompatActivity {

    WebView mountWebView;
    ImageView imageViewMount;
    String name, URLString, URLString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mount_detail_view);


        mountWebView = (WebView) findViewById(R.id.webViewMountDetail);
        imageViewMount = (ImageView) findViewById(R.id.imageViewMount);


        name = getIntent().getStringExtra("name");
        final String url = getIntent().getStringExtra("imageurl");

        Picasso.with(this).load("http://wow.zamimg.com/images/wow/icons/large/" + url + ".jpg").into(imageViewMount);


        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        mountWebView.getSettings().setBuiltInZoomControls(true);
        mountWebView.getSettings().setSupportZoom(true);
        mountWebView.getSettings().getLoadsImagesAutomatically();
        mountWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        mountWebView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Loading mount info, just one second more...");
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });

        mountWebView.loadUrl("http://wow.gamepedia.com/" + name);
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
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,URLString2);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }
}
