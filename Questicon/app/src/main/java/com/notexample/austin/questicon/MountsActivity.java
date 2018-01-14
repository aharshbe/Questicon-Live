package com.notexample.austin.questicon;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
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
import java.util.Timer;
import java.util.TimerTask;

import cz.msebera.android.httpclient.Header;

public class MountsActivity extends AppCompatActivity {
    ArrayList<MountModel> mountModels;
    CustomAdapterMount adapterMount;
    String theySearched = "";
    ArrayList<MountModel> mountModels2;
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

                    assert listViewMount != null;
                    listViewMount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            if (theySearched.equalsIgnoreCase("")) {

                                MountModel mount = mountModels.get(position);

                                Intent myIntent = new Intent(MountsActivity.this, MountDetailView.class);
                                myIntent.putExtra("position", position);
                                myIntent.putExtra("name", mount.getName());
                                myIntent.putExtra("imageurl", mount.getImageurl());
                                startActivity(myIntent);
                            }else {

                                MountModel mount = mountModels2.get(position);

                                Intent myIntent = new Intent(MountsActivity.this, MountDetailView.class);
                                myIntent.putExtra("position", position);
                                myIntent.putExtra("name", mount.getName());
                                myIntent.putExtra("imageurl", mount.getImageurl());
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
        setContentView(R.layout.activity_mounts);

        mount();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("HI!");
        builder.setIcon(R.drawable.gyro_animation);
        builder.setMessage("Loading Mounts, just two seconds...");
        builder.setCancelable(false);

        final AlertDialog closedialog= builder.create();

        closedialog.show();

        final Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            public void run() {
                closedialog.dismiss();
                timer2.cancel(); //this will cancel the timer of the system
            }
        }, 2000);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);


        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                theySearched = newText;

                mountModels2 = new ArrayList<>();

                for (int i = 0; i < mountModels.size(); i++) {

                    if (mountModels.get(i).getName().toLowerCase().contains(newText.toLowerCase())) {
                        mountModels2.add(mountModels.get(i));
                    }

                }
                ListView listViewMounts = (ListView) findViewById(R.id.listViewMounts);
                mountModels.contains(newText);
                adapterMount = new CustomAdapterMount(MountsActivity.this, mountModels2);
                listViewMounts.setAdapter(adapterMount);

                adapterMount.notifyDataSetChanged();


                return false;
            }
        });


        return true;
    }
}
