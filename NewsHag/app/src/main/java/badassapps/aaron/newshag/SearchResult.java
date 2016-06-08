package badassapps.aaron.newshag;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by drewmahrt on 3/2/16.
 */
public class SearchResult {
    @SerializedName("results")
    private ArrayList<Article> results;

    public ArrayList<Article> getResults() {
        return results;
    }

    public void setResults(ArrayList<Article> results) {
        this.results = results;
    }
}
