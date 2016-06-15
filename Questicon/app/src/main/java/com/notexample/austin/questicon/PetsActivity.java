package com.notexample.austin.questicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

public class PetsActivity extends AppCompatActivity {
    ArrayList<PetsModel> petsModels;
    CustomAdapterPets adapterPets;
    JsonHttpResponseHandler jsonHttpResponseHandler = new JsonHttpResponseHandler() {


        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responseBody) {


            try {
                JSONArray jsonArray = responseBody.getJSONArray("pets");


                for (int i = 0; i < jsonArray.length(); i++) {
                    final JSONObject pet = jsonArray.getJSONObject(i);

                    if (!pet.has("name") || !pet.has(("icon")))
                        continue;
                    final PetsModel petsModel = new PetsModel(pet.getString("name"), pet.getString("icon"));
                    petsModels.add(petsModel);
                    adapterPets.notifyDataSetChanged();


                    ListView listViewPets = (ListView) findViewById(R.id.listViewPets);


                    listViewPets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            PetsModel pet = petsModels.get(position);

                            Intent myIntent = new Intent(PetsActivity.this, PetDetailView.class);
                            myIntent.putExtra("position", position);
                            myIntent.putExtra("name", pet.getNamePet());
                            myIntent.putExtra("imageurl", pet.getImagePet());
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
        setContentView(R.layout.activity_pets);

        pet();
    }

    public void pet() {

        ListView listViewPet = (ListView) findViewById(R.id.listViewPets);
        petsModels = new ArrayList<>();
        adapterPets = new CustomAdapterPets(this, petsModels);
        listViewPet.setAdapter(adapterPets);


        final AsyncHttpClient client = new AsyncHttpClient();


        // Not sure why this boolean isn't working but the objective was to make it so that if a user enter's nothing, the search doesn't happen


        client.get("https://us.api.battle.net/wow/pet/?locale=en_US&apikey=wheces9zargz65mhza5jfv9nentuy2gg", jsonHttpResponseHandler);


    }
}
