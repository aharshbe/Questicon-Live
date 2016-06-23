package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class CharacterActivity extends AppCompatActivity {

    ArrayList<CharacterModel> characterModels;
    CustomAdapterCharacter adapter;
    ListView listView;
    EditText realm, charactername;
    String characterImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        checkFirstRun();

        listView = (ListView) findViewById(R.id.listView);
        realm = (EditText) findViewById(R.id.realm);
        charactername = (EditText) findViewById(R.id.charactername);


        characterModels = new ArrayList<>();
        adapter = new CustomAdapterCharacter(this, characterModels);
        listView.setAdapter(adapter);





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return true;
    }




    public void APICALL() {

        final AsyncHttpClient client = new AsyncHttpClient();

        final String searchVariableName = charactername.getText().toString();
        final String searchVariableRealm = realm.getText().toString();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/character/" + searchVariableRealm + "/" + searchVariableName + "?fields=appearance&locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg\n", new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject responseBody) {


                try {
                    String name = responseBody.getString("name");
                    String battlegroup = responseBody.getString("battlegroup");
                    String newRaceName = "";
                    String newClassName = "";
                    String newFaction = "";
                    String newGender = "";
                    final String image = responseBody.getString("thumbnail");
                    int classWow = responseBody.getInt("class");
                    int race = responseBody.getInt("race");
                    int gender = responseBody.getInt("gender");
                    int ap = responseBody.getInt("achievementPoints");
                    int faction = responseBody.getInt("faction");
                    int level = responseBody.getInt("level");
                    int kills = responseBody.getInt("totalHonorableKills");


                    CharacterModel character = new CharacterModel(name, battlegroup, image, classWow, race, gender, ap, faction, level, kills, newRaceName, newClassName, newFaction, newGender);


                    String imageThumb = responseBody.getString("thumbnail");


                    ArrayList<CharacterModel> characterModels = new ArrayList<>();
                    CustomAdapterCharacter adapter = new CustomAdapterCharacter(CharacterActivity.this, characterModels);

                    listView.setAdapter(adapter);


                    adapter.add(character);

                    adapter.notifyDataSetChanged();

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent myIntent = new Intent(CharacterActivity.this, CharacterDetailView.class);



                            try {

                                realm = (EditText) findViewById(R.id.realm);
                                charactername = (EditText) findViewById(R.id.charactername);

                                characterImage = responseBody.getString("thumbnail");
                                myIntent.putExtra("url2", characterImage);
                                myIntent.putExtra("nameChar", charactername.getText().toString());
                                myIntent.putExtra("nameRealm",  realm.getText().toString());
                                startActivity(myIntent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getApplicationContext(), "No character under the name " + searchVariableName + " found.",
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    public void clickingSearch(View view) {


        APICALL();

        realm = (EditText) findViewById(R.id.realm);
        charactername = (EditText) findViewById(R.id.charactername);

        Intent myIntent = new Intent(CharacterActivity.this, CharacterDetailView.class);


        myIntent.putExtra("url2", characterImage);
        myIntent.putExtra("nameChar", charactername.getText().toString());
        myIntent.putExtra("nameRealm", realm.getText().toString());
        startActivity(myIntent);


    }

    public void clickingInfo(MenuItem item) {
        InfoDiaglogue();
    }

    public void InfoDiaglogue() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("So you're a little confused...");
        builder2.setIcon(R.mipmap.ic_launcher_questicon);
        builder2.setCancelable(true);
        builder2.setMessage("To search for your character: \n\n Just place your character's realm in the first box and their name in the second, lastly hit the search button at the bottom of the screen! \n\n **Only characters on a US realm can be searched for the moment, sorry about that!**");
        builder2.setPositiveButton(
                "Thanks!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                        return;
                    }
                });

        AlertDialog alert12 = builder2.create();
        alert12.show();
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun3", true);
        if (isFirstRun) {

            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle("Dear WoW player...");
            builder2.setIcon(R.mipmap.ic_launcher_questicon);
            builder2.setCancelable(true);
            builder2.setMessage("To search for your character: \n\n Just place your character's realm in the first box and their name in the second, lastly hit the search button at the bottom of the screen! \n\n **Only characters on a US realm can be searched for the moment, sorry about that!**");
            builder2.setPositiveButton(
                    "Thanks!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                            return;
                        }
                    });

            AlertDialog alert12 = builder2.create();
            alert12.show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun3", false)
                    .apply();
        }
    }
}










