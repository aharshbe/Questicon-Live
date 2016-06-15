package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class DungeonActivity extends AppCompatActivity {
    ArrayList<DungeonModel> dungeonModels;
    CustomAdapterDungeon adapterDungeon;
    ArrayList<DungeonModel> dungeonModels1;
    JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {


        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


            try {
                JSONArray jsonArray = responseBody.getJSONArray("zones");


                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject dungeon = jsonArray.getJSONObject(i);
                    final JSONObject bosses = jsonArray.getJSONObject(1);

                    if (!dungeon.has("name") || !dungeon.has(("description")) || !dungeon.has(("numPlayers")) ||
                            !dungeon.has(("advisedMinLevel")) || !dungeon.has(("advisedMaxLevel")) ||
                            !dungeon.has(("floors")) || !dungeon.has(("bosses")) || !dungeon.has("location"))
                        continue;
                    final DungeonModel dungeonModel = new DungeonModel(dungeon.getString("name"), dungeon.getString("description"), dungeon.getString("location"),
                            bosses.getString("name"), bosses.getString("description"), dungeon.getString("numPlayers"), dungeon.getString("advisedMaxLevel"),
                            dungeon.getString("advisedMinLevel"), dungeon.getString("floors"));
                    dungeonModels.add(dungeonModel);
                    adapterDungeon.notifyDataSetChanged();
//

                    ListView listViewDungeon = (ListView) findViewById(R.id.listViewDungeon);


                    listViewDungeon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            DungeonModel dungeon = dungeonModels.get(position);

                            Intent myIntent = new Intent(DungeonActivity.this, DunegonDetailView.class);
                            myIntent.putExtra("position", position);
                            myIntent.putExtra("des", dungeon.getDescriptionD());
                            myIntent.putExtra("name", dungeon.getNameD());
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
        setContentView(R.layout.activity_dungeon);

        dungeon();
    }

    public void dungeon() {

        ListView listViewDungeon = (ListView) findViewById(R.id.listViewDungeon);
        dungeonModels = new ArrayList<>();
        adapterDungeon = new CustomAdapterDungeon(this, dungeonModels);
        listViewDungeon.setAdapter(adapterDungeon);


        final AsyncHttpClient client = new AsyncHttpClient();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/zone/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", jsonHttpResponseHandler);


    }

    public void clickingSearchDungeon(View view) {
        EditText search = (EditText) findViewById(R.id.SearchDungeon);
         dungeonModels1 = new ArrayList<>();

        for (int i = 0; i < dungeonModels.size() ; i++) {

            if (dungeonModels.get(i).getNameD().toLowerCase().contains(search.getText().toString().toLowerCase())){
                dungeonModels1.add(dungeonModels.get(i));
            }

        }
        ListView listViewDungeon = (ListView) findViewById(R.id.listViewDungeon);
        dungeonModels.contains(search);
        adapterDungeon = new CustomAdapterDungeon(this, dungeonModels1);
        listViewDungeon.setAdapter(adapterDungeon);

        adapterDungeon.notifyDataSetChanged();



    }
}
