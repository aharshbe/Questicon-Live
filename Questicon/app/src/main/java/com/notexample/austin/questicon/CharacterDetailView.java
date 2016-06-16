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
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CharacterDetailView extends AppCompatActivity {

    ImageView imageView;
    String nameRealm, nameChar, URLString, URLString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SearchWithWebview();



        final String picasso = getIntent().getStringExtra("url2");
        imageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load("https://us.battle.net/static-render/us/"+ picasso).into(imageView);
    }

    public void SearchWithWebview(){

         nameChar = getIntent().getStringExtra("nameChar");
         nameRealm = getIntent().getStringExtra("nameRealm");


        WebView webViewCharacter = (WebView) findViewById(R.id.webViewCharDetail);


        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        webViewCharacter.getSettings().setBuiltInZoomControls(true);
        webViewCharacter.getSettings().setSupportZoom(true);
        webViewCharacter.setInitialScale(100);
        webViewCharacter.getSettings().getLoadsImagesAutomatically();
        webViewCharacter.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webViewCharacter.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Loading your character, just one second more...");
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });

        URLString= "http://us.battle.net/wow/en/character/"+nameRealm+"/"+nameChar+"/advanced".replaceAll("\\s+", "");
        URLString2 = URLString.replaceAll("\\s+", "");

        webViewCharacter.loadUrl("http://us.battle.net/wow/en/character/"+nameRealm+"/"+nameChar+"/advanced");





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
