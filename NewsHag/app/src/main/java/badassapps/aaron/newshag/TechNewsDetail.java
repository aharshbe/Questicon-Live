package badassapps.aaron.newshag;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.StaleDataException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TechNewsDetail extends AppCompatActivity {

    ArrayList<Article> mList;
    CustomAdapter adapter;
    ListView listView;
    LayoutInflater layoutInflater;

    // Constants
    // Content provider authority
    public static final String AUTHORITY = "badassapps.aaron.newshag.AppContentProvider";
    // Account type
    public static final String ACCOUNT_TYPE = "example.com";
    // Account
    public static final String ACCOUNT = "default_account";

    Account mAccount;

    // Global variables
    // A content resolver for accessing the provider
    ContentResolver mResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_news_detail);

        mAccount = createSyncAccount(this);

        mList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        final Cursor cursor = getContentResolver().query(AppContentProvider.CONTENT_URI, null, null, null, null);
        adapter = new CustomAdapter(this, cursor, 0);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(TechNewsDetail.this, Top10NewsD.class);

                try {
                    cursor.moveToPosition(position);

                } catch (IllegalStateException i) {
                    i.printStackTrace();
                    Toast.makeText(TechNewsDetail.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
                    ErrorExceptionDialogue();
                } catch (CursorIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    Toast.makeText(TechNewsDetail.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
                    ErrorExceptionDialogue();
                }

                try {
                    myIntent.putExtra("title", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_TITLE)));
                    myIntent.putExtra("abstract", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_ABSTRACT)));
                    myIntent.putExtra("thumbnail", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_THUMBNAIL)));
                    myIntent.putExtra("url", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_URL)));


                } catch (CursorIndexOutOfBoundsException i) {
                    i.printStackTrace();
                    Toast.makeText(TechNewsDetail.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
                    ErrorExceptionDialogue();
                } catch (StaleDataException s) {
                    s.printStackTrace();
                    Toast.makeText(TechNewsDetail.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
                    ErrorExceptionDialogue();

                }


                startActivity(myIntent);

            }
        });


        //Step 1 (for content resolver)
        //new Handler
        getContentResolver().registerContentObserver(AppContentProvider.CONTENT_URI, true, new
                NewsContentObserver
                (new Handler()));

        //Performs manual sync
        Bundle settingsBundle = new Bundle();
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_MANUAL, true);
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_EXPEDITED, true);


        /*
         * Request the sync for the default account, authority, and
         * manual sync settings
         */

        //REQUESTS A SYNC FOR THE ACCOUNT
        //i.e. if there's no cache, or app hasn't been used for several days...
        ContentResolver.requestSync(mAccount, AUTHORITY, settingsBundle);

        ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
        ContentResolver.addPeriodicSync(
                mAccount,
                AUTHORITY,
                Bundle.EMPTY,
                6000);

        Toast.makeText(TechNewsDetail.this, "Syncing...", Toast.LENGTH_SHORT).show();

    }

    public void clickingFavs(MenuItem item) {
        Intent intent = new Intent(TechNewsDetail.this, FavoritesD.class);
        startActivity(intent);
    }

    public void clickingFavsToAdd(MenuItem item) {
        insertFavorite();
    }

    //CustomAdapter for our Cursor
    public class CustomAdapter extends CursorAdapter {
        private LayoutInflater cursorInflater;

        public CustomAdapter(Context context, Cursor cursor, int flags) {
            super(context, cursor, flags);
            cursorInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);


        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            // Find fields to populate in inflated template
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView abstract1 = (TextView) view.findViewById(R.id.abstract1);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            // Extract properties from cursor
//            String urlString = cursor.getString(cursor.getColumnIndexOrThrow("url"));
            String titleString = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            String imageString = cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_" +
                    "standard"));
            String abstractString = cursor.getString(cursor.getColumnIndexOrThrow("abstract"));

            // Populate fields with extracted properties
            abstract1.setText(abstractString);
            if (imageString != null && !imageString.equals("")) {
                Picasso.with(TechNewsDetail.this)
                        .load
                                (imageString).into
                        (image);
                title.setText(titleString);

            }
        }
    }


    //Will inflate our menu's search functionality
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search, menu);
        inflater.inflate(R.menu.access_db, menu);

//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    /**
     * Create a new dummy account for the sync adapter
     *
     * @param context The application context
     */
    public static Account createSyncAccount(Context context) {
        // Create the account type and default account
        Account newAccount = new Account(
                ACCOUNT, ACCOUNT_TYPE);
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) context.getSystemService(
                        ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }
        return newAccount;
    }

    public class NewsContentObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public NewsContentObserver(Handler handler) {
            super(handler);
        }


        @Override
        public void onChange(boolean selfChange, Uri uri) {
            //do stuff on UI thread
            Cursor cursor = adapter.swapCursor(getContentResolver().query(AppContentProvider
                            .CONTENT_URI,
                    null, null,
                    null, null));
            if (cursor != null) {
            }


        }
    }

    public void ErrorExceptionDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_news);
        builder1.setMessage("Please wait to read story, News Hag needs a little londer to load!" + "\n\n" + "Try going back to the nav drawer and checking out top news in the mean time!" + "\n\n" + "Try closing and reopening app.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();


                        return;
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    protected void onDestroy() {
        super.onDestroy();

        System.out.println("On destroy happened Books Activity");
    }

    public void insertFavorite() {

        //Create our db object
        NewsDBOpenHelper helpMe = new NewsDBOpenHelper(this, "favorites", null, 1);

        //Insert values using writable db
        SQLiteDatabase db = helpMe.getWritableDatabase();

        //Receive our values from our class and pass them through here!
        ContentValues cv = new ContentValues();

        cv.put(NewsDBOpenHelper.COL_FAV, "1");
        cv.put(NewsDBOpenHelper.COL_TITLE,getIntent().getStringExtra("title") );
        cv.put(NewsDBOpenHelper.COL_URL, getIntent().getStringExtra("url"));
        cv.put(NewsDBOpenHelper.COL_THUMBNAIL, getIntent().getStringExtra("thumbnail"));

        String id = getIntent().getStringExtra("id");  //is the id

        long insertColumn = db.insert(NewsDBOpenHelper.FAVS_HAG_TABLE, null,cv);
        long insertColumnValue = db.update(NewsDBOpenHelper.FAVS_HAG_TABLE, cv, NewsDBOpenHelper.COL_ID + " = ?", new String[]{id});
        db.close();
        Toast.makeText(TechNewsDetail.this, "Insert into columnID " + insertColumn, Toast.LENGTH_SHORT).show();
        Toast.makeText(TechNewsDetail.this, "Inserted data into columnID " + insertColumnValue, Toast.LENGTH_SHORT).show();

    }
}
