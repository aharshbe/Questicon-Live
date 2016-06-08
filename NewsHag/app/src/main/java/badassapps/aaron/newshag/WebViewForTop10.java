package badassapps.aaron.newshag;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebViewForTop10 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_for_top10);

        String detailUrl = getIntent().getStringExtra("url");

        webView = (WebView) findViewById(R.id.loadStory);
        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...", true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().getLoadsImagesAutomatically();
        webView.setInitialScale(170);
        webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
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

        webView.loadUrl(detailUrl);

    }

//    public void clickingminus(View view) {
//        webView.zoomOut();
//        Toast.makeText(WebViewForTop10.this, "you clicked zoom out", Toast.LENGTH_SHORT).show();
//
//    }
//
//    public void clickingplus(View view) {
//        Toast.makeText(WebViewForTop10.this, "you clicked zoom in", Toast.LENGTH_SHORT).show();
//    }
}
