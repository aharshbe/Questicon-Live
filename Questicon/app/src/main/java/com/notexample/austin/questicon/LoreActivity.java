package com.notexample.austin.questicon;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
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
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class LoreActivity extends AppCompatActivity {
    ArrayList<LoreModel> loreModelArrayList;
    CustomAdapterLore adapterLore;

    JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {


        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


            try {
                JSONArray jsonArrayItems = responseBody.getJSONArray("items");


                for (int i = 0; i < jsonArrayItems.length(); i++) {

                    final JSONObject items = jsonArrayItems.getJSONObject(i);


                    if (!items.has("snippet"))
                        continue;
                    final LoreModel loreModel = new LoreModel(items.getJSONObject("snippet").getString("title"), items
                            .getJSONObject("snippet").getJSONObject("thumbnails")
                            .getJSONObject("default").getString("url"), items.getJSONObject("snippet").getJSONObject("resourceId").getString("videoId"));
                    loreModelArrayList.add(loreModel);
                    adapterLore.notifyDataSetChanged();


                    ListView listViewlore = (ListView) findViewById(R.id.listViewLore);


                    assert listViewlore != null;
                    listViewlore.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            LoreModel loreVideo = loreModelArrayList.get(position);
                            Intent myIntent = new Intent(LoreActivity.this, DetailViewLore.class);
                            myIntent.putExtra("position", position);
                            myIntent.putExtra("urlVideo", loreVideo.getURLVideo());
                            startActivity(myIntent);
                            Toast.makeText(LoreActivity.this, "Opening video", Toast.LENGTH_SHORT).show();


                        }
                    });


                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(LoreActivity.this, "There are "+loreModelArrayList.size()+ " videos to search through.", Toast.LENGTH_SHORT).show();



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
        setContentView(R.layout.activity_lore_stuff);

        lore();
    }

    public void lore() {

        ListView listViewLore = (ListView) findViewById(R.id.listViewLore);
        loreModelArrayList = new ArrayList<>();
        adapterLore = new CustomAdapterLore(this, loreModelArrayList);
        listViewLore.setAdapter(adapterLore);


        final AsyncHttpClient client = new AsyncHttpClient();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen
        client.get("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL6037698E84060287&key=AIzaSyA-7BAluixrnUtFKMwOW_sV0as0loF7pok&maxResults=50&pageToken=CJYBEAA", jsonHttpResponseHandler);

        client.get("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL6037698E84060287&key=AIzaSyA-7BAluixrnUtFKMwOW_sV0as0loF7pok&maxResults=50&pageToken=CGQQAA", jsonHttpResponseHandler);

        client.get("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL6037698E84060287&key=AIzaSyA-7BAluixrnUtFKMwOW_sV0as0loF7pok&maxResults=50&pageToken=CDIQAA", jsonHttpResponseHandler);

        client.get("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL6037698E84060287&key=AIzaSyA-7BAluixrnUtFKMwOW_sV0as0loF7pok&maxResults=50", jsonHttpResponseHandler);


    }

}


