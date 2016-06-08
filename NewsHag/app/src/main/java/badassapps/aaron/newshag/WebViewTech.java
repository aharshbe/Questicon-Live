package badassapps.aaron.newshag;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTech extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_movies);

        webView = (WebView) findViewById(R.id.loadBooks);

        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);


        webView.getSettings().setSupportZoom(true);
        webView.getSettings().getTextZoom();
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().getLoadsImagesAutomatically();
        webView.setInitialScale(170);
        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.setMessage("Sorry, still loading");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (pd != null && pd.isShowing()) {
                    pd.dismiss();
                }
            }
        });


        webView.loadUrl("http://www.nytimes.com/2016/06/02/world/europe/mikhail-gorbachev-interview-vladimir-putin.html?hp&action=click&pgtype=Homepage&clickSource=story-heading&module=second-column-region&region=top-news&WT.nav=top-news&_r=0");

    }


}
