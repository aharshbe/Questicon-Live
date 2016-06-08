package badassapps.aaron.newshag;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by austin on 6/3/16.
 */


public class SyncAdapterTech extends AbstractThreadedSyncAdapter {

    // Global variables
    // Define a variable to contain a content resolver instance
    ContentResolver mContentResolver;

    /**
     * Set up the sync adapter
     */
    public SyncAdapterTech(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();
    }

    /**
     * Set up the sync adapter. This form of the
     * constructor maintains compatibility with Android 3.0
     * and later platform versions
     */
//    public SyncAdapter(
//            Context context,
//            boolean autoInitialize,
//            boolean allowParallelSyncs) {
//        super(context, autoInitialize, allowParallelSyncs);
//        /*
//         * If your app uses a content resolver, get an instance of it
//         * from the incoming Context
//         */
//        mContentResolver = context.getContentResolver();
//
//    }

    /**
     * This is the method that contains the logic for our sync.
     *
     * @param account
     * @param extras
     * @param authority
     * @param provider
     * @param syncResult
     */

    //Works on a service and works on a workerthread
    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {

        //Use our content provider to empty our local database.
        //The data will be replaced with the new results from the api call below.
        mContentResolver.delete(AppContentProvider.CONTENT_URI, null, null);

        //Do api call to nytimes to get new data; gson stuff goes here...
        String data = "";
        try {
            URL url = new URL("https://api.nytimes.com/svc/topstories/v2/technology.json?api-key=46b73ba327704ff7994590206a6eed18");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            Log.d("TAG", "startedTecH");
            InputStream inStream = connection.getInputStream();
            data = getInputData(inStream);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        //Organize our out response by using gson to instantiate a SearchResult data model.
        Gson gson = new Gson();
        TechArticle result = gson.fromJson(data, TechArticle.class);

        //Loop through the results and insert the contents of each NewsItem into the database via our content provider.
        for (int i = 0; i < result.getResults().size(); i++) {
            ContentValues values = new ContentValues();

            values.put("title", result.getResults().get(i).getTITLE());
            values.put("url", result.getResults().get(i).getURL());
            values.put("thumbnail_standard", result.getResults().get(i).getIMAGE());
            values.put("abstract", result.getResults().get(i).getABSTRACT());

            mContentResolver.insert(AppContentProvider.CONTENT_URI, values);
//            Log.d(TAG,"Latest story: "+result.getResults().get(i).getTitle());
        }
    }

    /**
     * Helper method for turning an InputStream into a String.
     *
     * @param inStream
     * @return String with the contents of the InputStream.
     * @throws IOException
     */
    private String getInputData(InputStream inStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

        String data = null;

        while ((data = reader.readLine()) != null) {
            builder.append(data);
        }

        reader.close();

        return builder.toString();
    }
}

