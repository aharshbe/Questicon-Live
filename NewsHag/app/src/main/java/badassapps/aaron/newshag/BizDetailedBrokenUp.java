package badassapps.aaron.newshag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BizDetailedBrokenUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_detailed_broken_up);
    }


    public void clickingReadOnBiz(View view) {
        Intent intent = new Intent(BizDetailedBrokenUp.this, WebViewBiz.class);
        startActivity(intent);


    }
}
