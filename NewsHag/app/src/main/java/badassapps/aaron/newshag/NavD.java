package badassapps.aaron.newshag;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.StaleDataException;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NavD extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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
        setContentView(R.layout.activity_nav_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkFirstRun();
        NOTIFICATIONBox();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        mAccount = createSyncAccount(this);

        mList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listViewNavD);
        final Cursor cursor = getContentResolver().query(AppContentProvider.CONTENT_URI, null, null, null, null);
        adapter = new CustomAdapter(this, cursor, 0);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Currently needs our attention; need to create intent
                Intent myIntent = new Intent(NavD.this, NavDDetailView.class);

                try {

                    cursor.moveToPosition(position);


                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    System.out.println("Illegal state exception");
                    Toast.makeText(NavD.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
                    ErrorExceptionDialogue();
                }

                try {
                    myIntent.putExtra("title", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_TITLE)));
                    myIntent.putExtra("id", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_ID)));
                    myIntent.putExtra("abstract", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_ABSTRACT)));
                    myIntent.putExtra("thumbnail", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_THUMBNAIL)));
                    myIntent.putExtra("url", cursor.getString(cursor.getColumnIndex(NewsDBOpenHelper
                            .COL_URL)));
                } catch (CursorIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("caught index out of bounds exception");
                    Toast.makeText(NavD.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
//                    ErrorExceptionDialogue();
                } catch (StaleDataException i) {
                    i.printStackTrace();
                    System.out.println("caught stale data exception");
                    Toast.makeText(NavD.this, "Please wait to read story, News Hag needs a little londer to load! Try closing and reopening app.", Toast.LENGTH_LONG).show();
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

        Toast.makeText(NavD.this, "Syncing...", Toast.LENGTH_SHORT).show();
    }

    public void clickingTech(MenuItem item) {
        Intent intent = new Intent(NavD.this, TechNewsDetail.class);
        startActivity(intent);

    }

    public void clickingBiz(MenuItem item) {
        Intent intent = new Intent(NavD.this, BizNewsDetail.class);
        startActivity(intent);
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
                Picasso.with(NavD.this)
                        .load
                                (imageString).into
                        (image);
                title.setText(titleString);

            }
        }
    }

    //Start the UI stuff
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search, menu);
        inflater.inflate(R.menu.infobutton, menu);


//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_top10) {
            // Handle the camera action

        } else if (id == R.id.nav_tech) {

        } else if (id == R.id.nav_biz) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickingTopTen(MenuItem item) {
        Intent intent = new Intent(NavD.this, MainActivity.class);
        startActivity(intent);
    }

    public void clickingShareNav(MenuItem item) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://github.com/aartea/NewsHag");
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
    }


    public void NOTIFICATIONBox() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //If there is internet connection then the user will be presented with a notification that displays the top story
        if (networkInfo != null && networkInfo.isConnected()) {

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(6);


        } else {
            NoInternetDialogue();

            Intent intent = new Intent(NavD.this, MainActivity.class);
            Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);

            PendingIntent pendingIntent = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent, 0);
            PendingIntent pendingIntent1 = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent1, 0);


            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NavD.this);
            mBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
            mBuilder.setContentTitle("No internet connection!");
            Notification notification = mBuilder.build();
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            mBuilder.setSound(notification.sound = Uri.parse("android.resource://"
                    + this.getPackageName() + "/" + R.raw.notif));
            mBuilder.setVibrate(pattern);
            mBuilder.setLights(Color.RED, 500, 500);
            mBuilder.setStyle(new NotificationCompat.InboxStyle());
            mBuilder.setContentText("To use the app, please enable WIFI, Thanks!");
            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigTextStyle);
            mBuilder.addAction(android.R.drawable.ic_menu_info_details, "Connect WIFI", pendingIntent1);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(6, bigTextStyle.build());
        }


    }


    private void NOTIFICATIONisAllowed() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        //If there is internet connection then the user will be presented with a notification that displays the top story
        if (networkInfo != null && networkInfo.isConnected()) {
            Intent intent1 = new Intent(NavD.this, MainActivity.class);

            PendingIntent pendingIntent1 = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent1, 0);

            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.news)).build();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NavD.this);
            mBuilder.setSmallIcon(R.drawable.ic_chrome_reader_mode_black_24dp);
            mBuilder.setContentTitle("BREAKING NEWS!");
            mBuilder.setContentText("The News Hag team: Check out the latest story!");
            mBuilder.setContentIntent(pendingIntent1);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigPictureStyle);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, bigPictureStyle.build());
            notificationManager.cancel(6);


        } else {
            //If there is no internet connection present, the user is presented with a notification that lasts 30 seconds with the option to go into settings and turn it on via click
            Intent intent = new Intent(NavD.this, MainActivity.class);
            Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);

            PendingIntent pendingIntent = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent, 0);
            PendingIntent pendingIntent1 = PendingIntent.getActivity(NavD.this, (int) System.currentTimeMillis(), intent1, 0);


            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NavD.this);
            mBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
            mBuilder.setContentTitle("No internet connection!");
            Notification notification = mBuilder.build();
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            mBuilder.setSound(notification.sound = Uri.parse("android.resource://"
                    + this.getPackageName() + "/" + R.raw.notif));
//            mBuilder.setVibrate(pattern);
//            mBuilder.setLights(Color.RED, 500, 500);
            mBuilder.setStyle(new NotificationCompat.InboxStyle());
            mBuilder.setContentText("To use the app, please enable WIFI, Thanks!");
            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigTextStyle);
            mBuilder.addAction(android.R.drawable.ic_menu_info_details, "Connect WIFI", pendingIntent1);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(6, bigTextStyle.build());
            notificationManager.cancel(1);
        }
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun) {

            MainDialogue();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

    public void clickingSettings(MenuItem item) {
        Intent intent = new Intent(NavD.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void NoInternetDialogue() {
        AlertDialog.Builder builder7 = new AlertDialog.Builder(this);
        builder7.setIcon(R.mipmap.ic_news);
        builder7.setMessage("No internet connection, please click below to enable connection!" + "\n" + "\n" + "-Sincerely, your developers");
        builder7.setCancelable(true);

        builder7.setPositiveButton(
                "Go to connection settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent1);


                        return;
                    }
                });

        builder7.setNegativeButton(
                "I'm alright",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(NavD.this, "Totally get it, you'll still be able to see saved stories!", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder7.create();
        alert11.show();

    }

    //Dialogue stuff goes here.
    public void firstDialogue() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_news);
        builder1.setMessage("To choose your favorite news topic instead of the top news section, select your favorite topic from the navigation drawer by swiping to the right from the edge of the screen or by clicking the three lines in the top left!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        secondDialogue();

                        return;
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public void secondDialogue() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setIcon(R.mipmap.ic_news);
        builder2.setMessage("To view the Top 10 most popular stories, swipe from the left or click the 3 lines in the top-left");
        builder2.setCancelable(true);

        builder2.setPositiveButton(
                "Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });

        AlertDialog alert12 = builder2.create();
        alert12.show();
    }

    public void ThirdDialogue() {
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setIcon(R.mipmap.ic_news);
        builder3.setMessage("Would you like tips on how to use the app?");
        builder3.setCancelable(true);

        builder3.setPositiveButton(
                "Yes please!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        firstDialogue();

                        return;
                    }
                });

        builder3.setNegativeButton(
                "No thanks.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(NavD.this, "Oh okay, nothing then, you pro user you", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });


        AlertDialog alert13 = builder3.create();
        alert13.show();
    }

    public void MainDialogue() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setIcon(R.mipmap.ic_news);
        builder1.setMessage("Would you like to recieve the latest news from News Hag?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes please!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(NavD.this, "Great you'll recieve stuff!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();

                        NOTIFICATIONisAllowed();
                        ThirdDialogue();

                        return;
                    }
                });

        builder1.setNegativeButton(
                "No thanks.",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(NavD.this, "Oh okay, nothing then", Toast.LENGTH_SHORT).show();
                        dialog.cancel();

                        ThirdDialogue();

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
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

    public void clickingFavoritesNav(MenuItem item) {
        Intent intent = new Intent(NavD.this, FavoritesD.class);
        startActivity(intent);
    }

    public void clickingInfo(MenuItem item) {
        firstDialogue();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("on Destroy happened, navD");
    }
}
