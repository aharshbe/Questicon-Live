package badassapps.aaron.newshag;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Top10NewsD extends AppCompatActivity {
    TextView body, title;
    ImageView image;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10_news_d);

        String detailTitle = getIntent().getStringExtra("title");
        String detailAbstract = getIntent().getStringExtra("abstract");
        String detailThumb = getIntent().getStringExtra("thumbnail");
        String detailUrl = getIntent().getStringExtra("url");

        body = (TextView) findViewById(R.id.body);
        title = (TextView) findViewById(R.id.title);
        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);
        title.setMovementMethod(new ScrollingMovementMethod());
        body.setMovementMethod(new ScrollingMovementMethod());


        body.setMovementMethod(new ScrollingMovementMethod());

        body.setText(detailAbstract);
        title.setText(detailTitle);

        if (detailThumb != null && !detailThumb.equals("")) {
            Picasso.with(Top10NewsD.this)
                    .load
                            (detailThumb).into
                    (image);
        }
    }

    public void clickingReadOn(View view) {
        Intent intent = new Intent(Top10NewsD.this, WebViewForTop10.class);
        intent.putExtra("url", getIntent().getStringExtra("url"));
        startActivity(intent);
    }

    public void clickingFavsToAdd(MenuItem item) {

        Toast.makeText(Top10NewsD.this, "Added the story to your favorites!", Toast.LENGTH_SHORT).show();
        insertFavorite();


    }


    public void clickingShare(MenuItem item) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getIntent().getStringExtra("url"));
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shared_icon, menu);
        inflater.inflate(R.menu.making_fav, menu);
        return true;
    }

    public void insertFavorite(){

        //Create our db object
        NewsDBOpenHelper helpMe = new NewsDBOpenHelper(this, "favorites", null, 1);

        //Insert values using writable db
        SQLiteDatabase db = helpMe.getWritableDatabase();

        //Receive our values from our class and pass them through here!
        ContentValues cv = new ContentValues();

        cv.put(NewsDBOpenHelper.COL_FAV, getIntent().getStringExtra("url"));
        cv.put(NewsDBOpenHelper.COL_FAV, getIntent().getStringExtra("title"));



        long insertColumn = db.insert(NewsDBOpenHelper.NEWS_HAG_TABLE, null, cv);
        db.close();
        Toast.makeText(Top10NewsD.this, "Insert into columnID "+ insertColumn, Toast.LENGTH_SHORT).show();

    }

}
