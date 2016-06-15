package com.notexample.austin.questicon;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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

public class BossesActivity extends AppCompatActivity {
    ArrayList<BossesModel> bossesModels;
    EditText searchEditText;
    CustomAdapterBosses adapterBosses;
    String theySearched = "";
    ArrayList<BossesModel> bossesModels3;
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


                    ListView listViewBosses = (ListView) findViewById(R.id.listViewBosses);


                    assert listViewBosses != null;
                    listViewBosses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            if (theySearched.equalsIgnoreCase("")) {

                                BossesModel boss = bossesModels.get(position);

                                Intent myIntent = new Intent(BossesActivity.this, BossesDetailView.class);
                                myIntent.putExtra("position", position);
                                myIntent.putExtra("des", boss.getDescription());
                                myIntent.putExtra("name", boss.getName());

                                startActivity(myIntent);


                            } else {
                                BossesModel boss = bossesModels3.get(position);

                                Intent myIntent = new Intent(BossesActivity.this, BossesDetailView.class);
                                myIntent.putExtra("position", position);
                                myIntent.putExtra("des", boss.getDescription());
                                myIntent.putExtra("name", boss.getName());

                                startActivity(myIntent);

                            }


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

        handleIntent(getIntent());


    }

    @Override
    protected void onNewIntent(Intent intent) {

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow


        }
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

    public void clickingSearch(View view) {
        searchEditText = (EditText) findViewById(R.id.SearchBosses);
        ArrayList<BossesModel> bossesModels3 = new ArrayList<>();

        for (int i = 0; i < bossesModels.size(); i++) {

            if (bossesModels.get(i).getName().toLowerCase().contains(searchEditText.getText().toString().toLowerCase())) {
                bossesModels3.add(bossesModels.get(i));
            }

        }
        ListView listViewBosses = (ListView) findViewById(R.id.listViewBosses);
        bossesModels.contains(searchEditText);
        adapterBosses = new CustomAdapterBosses(this, bossesModels3);
        listViewBosses.setAdapter(adapterBosses);

        adapterBosses.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                theySearched = newText;

                bossesModels3 = new ArrayList<>();

                for (int i = 0; i < bossesModels.size(); i++) {

                    if (bossesModels.get(i).getName().toLowerCase().contains(newText.toLowerCase())) {
                        bossesModels3.add(bossesModels.get(i));
                    }

                }
                ListView listViewBosses = (ListView) findViewById(R.id.listViewBosses);
                bossesModels.contains(newText);
                adapterBosses = new CustomAdapterBosses(BossesActivity.this, bossesModels3);
                listViewBosses.setAdapter(adapterBosses);

                adapterBosses.notifyDataSetChanged();


                return false;
            }
        });


        return true;
    }


}



