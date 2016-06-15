package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MountsActivity extends AppCompatActivity {
    ArrayList<MountModel> mountModels;
    CustomAdapterMount adapterMount;
    JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {


        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


            try {
                JSONArray jsonArray = responseBody.getJSONArray("mounts");


                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject mount = jsonArray.getJSONObject(i);

                    if (!mount.has("name") || !mount.has(("icon")))
                        continue;
                    final MountModel mountModel = new MountModel(mount.getString("name"), mount.getString("icon"));
                    mountModels.add(mountModel);
                    adapterMount.notifyDataSetChanged();


                    ListView listViewMount = (ListView) findViewById(R.id.listViewMounts);


                    listViewMount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            MountModel mount = mountModels.get(position);

                            Intent myIntent = new Intent(MountsActivity.this, MountDetailView.class);
                            myIntent.putExtra("position", position);
                            myIntent.putExtra("name", mount.getName());
                            myIntent.putExtra("imageurl", mount.getImageurl());
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
        setContentView(R.layout.activity_mounts);

        mount();
    }

    public void mount() {

        ListView listViewMount = (ListView) findViewById(R.id.listViewMounts);
        mountModels = new ArrayList<>();
        adapterMount = new CustomAdapterMount(this, mountModels);
        listViewMount.setAdapter(adapterMount);


        final AsyncHttpClient client = new AsyncHttpClient();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/mount/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", jsonHttpResponseHandler);


    }
}
