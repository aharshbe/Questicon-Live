package com.notexample.austin.questicon;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.NotificationCompat;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

import cz.msebera.android.httpclient.Header;


public class CharacterActivity extends AppCompatActivity {
    LinkedList<String> items;
    ArrayAdapter<String> mAdapter;
    ListView listView;
    EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        items = new LinkedList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);
        editText = (EditText) findViewById(R.id.editText);

        CheckingInternetConnection();
        APICALL();
    }





    public void CheckingInternetConnection() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {



            Intent intent1 = new Intent(this, CharacterActivity.class);

            PendingIntent pendingIntent1 = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent1, 0);


            NotificationCompat.BigTextStyle bigPictureStyle = new NotificationCompat.BigTextStyle();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(android.R.drawable.star_on);
            mBuilder.setContentTitle("Welcome to Questicon");
            mBuilder.setContentIntent(pendingIntent1);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigPictureStyle);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1, bigPictureStyle.build());
            notificationManager.cancel(6);


        } else {
            Toast.makeText(getApplicationContext(), "Connection not ready",
                    Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(Settings.ACTION_WIFI_SETTINGS);


            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent1, 0);



            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setSummaryText("To use the app, please enable WIFI, Thanks!");

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(android.R.drawable.star_on);
            mBuilder.setContentTitle("Questicon Needs Attention");
            mBuilder.setContentText("To use the Question, you'll need to enable WIFI.");
            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigTextStyle);
            mBuilder.addAction(R.drawable.wifi, "To open WIFI settings", pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(6, bigTextStyle.build());
            notificationManager.cancel(1);


        }
    }

    public void APICALL() {

        final AsyncHttpClient client = new AsyncHttpClient();

        final String searchVariable = editText.getText().toString();

        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen




            client.get("https://us.api.battle.net/wow/character/sargeras/blimpie?fields=appearance&locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg\n", new JsonHttpResponseHandler() {


                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


                    try {

//                        JSONArray jsonArray = responseBody.getJSONArray("bosses");


                            items.add(responseBody.getString("thumbnail"));

                        mAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                    Toast.makeText(getApplicationContext(), "Process Not Successful",
                            Toast.LENGTH_SHORT).show();
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(CharacterActivity.this, Main2Activity.class);
                    myIntent.putExtra("position", position);
//                    String imageid = items.get(position);
                    String picasso = items.get(position);
//                    myIntent.putExtra("url", imageid);
                    myIntent.putExtra("url2", picasso);
                    startActivity(myIntent);
                }
            });


        }

    }









