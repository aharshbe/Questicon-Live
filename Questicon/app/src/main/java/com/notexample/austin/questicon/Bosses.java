package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
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


        client.get("https://us.api.battle.net/wow/boss/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


                try {
                    JSONArray jsonArray = responseBody.getJSONArray("bosses");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject bosses = jsonArray.getJSONObject(i);
                        if (!bosses.has("description") || !bosses.has(("name"))) continue;
                        BossesModel bossesModel = new BossesModel(bosses.get("name").toString(), bosses.get("description").toString());
                        bossesModels.add(bossesModel);
                        adapterBosses.notifyDataSetChanged();
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
        });

//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent myIntent = new Intent(Bosses.this, Main2Activity.class);
//                    myIntent.putExtra("position", position);
//                    String imageid = items.get(position);
//                    String picasso = items.get(position+1);
//                    myIntent.putExtra("url", imageid);
//                    myIntent.putExtra("url2", picasso);
//                    startActivity(myIntent);
//                }
//            });


    }

}



