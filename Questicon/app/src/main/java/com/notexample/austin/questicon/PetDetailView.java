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
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PetDetailView extends AppCompatActivity {

    WebView petWebView;
    ImageView imageViewPet;
     String name, URLString, URLString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail_view);


        petWebView = (WebView) findViewById(R.id.webViewPetDetail);
        imageViewPet = (ImageView) findViewById(R.id.imageViewPet);


          name = getIntent().getStringExtra("name");
        final String url = getIntent().getStringExtra("imageurl");

        Picasso.with(this).load("http://wow.zamimg.com/images/wow/icons/large/" + url + ".jpg").into(imageViewPet);


        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        petWebView.getSettings().setBuiltInZoomControls(true);
        petWebView.getSettings().setSupportZoom(true);
        petWebView.getSettings().getLoadsImagesAutomatically();
        petWebView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        petWebView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Loading pet info, just one second more...");
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });

        petWebView.loadUrl("http://wow.gamepedia.com/" + name);
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
