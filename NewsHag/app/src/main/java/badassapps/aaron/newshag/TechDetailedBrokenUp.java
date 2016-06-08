package badassapps.aaron.newshag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TechDetailedBrokenUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detailed_broken_up);
    }

    public void clickingReadOnBook(View view) {
        Intent intent = new Intent(TechDetailedBrokenUp.this, WebViewTech.class);
        startActivity(intent);
    }
}
