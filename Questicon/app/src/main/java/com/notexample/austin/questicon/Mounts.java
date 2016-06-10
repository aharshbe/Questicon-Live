package com.notexample.austin.questicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

import cz.msebera.android.httpclient.Header;

public class Mounts extends AppCompatActivity {
    LinkedList<String> items;
    ArrayAdapter<String> mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mounts);

        mounts();
    }

    public void mounts() {


        items = new LinkedList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView = (ListView) findViewById(R.id.listViewMounts);
        listView.setAdapter(mAdapter);



        final AsyncHttpClient client = new AsyncHttpClient();



        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/mount/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


                try {
                    JSONArray jsonArray = responseBody.getJSONArray("mounts");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject mounts = jsonArray.getJSONObject(i);
                        if (!mounts.has("name")) continue;
                        items.add(mounts.getString("name"));
                    }
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
