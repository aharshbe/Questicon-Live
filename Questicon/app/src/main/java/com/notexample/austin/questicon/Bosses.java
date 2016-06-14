package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

import cz.msebera.android.httpclient.Header;

public class Bosses extends AppCompatActivity {
    ArrayList<BossesModel> bossesModels;
    CustomAdapterBosses adapterBosses;
    ListView listView;
    //    String bossesDesciption;
    JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {


        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


            try {
                JSONArray jsonArray = responseBody.getJSONArray("bosses");


                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject bosses = jsonArray.getJSONObject(i);

                    if (!bosses.has("description") || !bosses.has(("name")) || !bosses.has(("level")) || !bosses.has(("heroicHealth")) || !bosses.has(("journalId")))
                        continue;
                    final BossesModel bossesModel = new BossesModel(bosses.get("name").toString(), bosses.get("description").toString(),
                            bosses.get("level").toString(), bosses.get("heroicHealth").toString(),
                            bosses.get("journalId").toString());
                    bossesModels.add(bossesModel);
                    adapterBosses.notifyDataSetChanged();
//                    bossesDesciption = bosses.get("description").toString();

                    ListView listViewBosses = (ListView) findViewById(R.id.listViewBosses);


                    listViewBosses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            BossesModel boss = bossesModels.get(position);

                            Intent myIntent = new Intent(Bosses.this, BossesDetailView.class);
                            myIntent.putExtra("position", position);
                            myIntent.putExtra("des", boss.getDescription());
                            myIntent.putExtra("name", boss.getName());
                            startActivity(myIntent);
                        }
                    });
                }


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
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosses);

        bosses();
    }

    public void bosses() {

        ListView listViewBosses = (ListView) findViewById(R.id.listViewBosses);
        bossesModels = new ArrayList<>();
        adapterBosses = new CustomAdapterBosses(this, bossesModels);
        listViewBosses.setAdapter(adapterBosses);


        final AsyncHttpClient client = new AsyncHttpClient();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/boss/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", jsonHttpResponseHandler);


    }

}



