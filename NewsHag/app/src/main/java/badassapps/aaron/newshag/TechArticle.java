package badassapps.aaron.newshag;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by austin on 6/1/16.
 */
public class TechArticle extends SearchResult implements Parcelable {

    @SerializedName("url")
    String URL;
    @SerializedName("title")
    String TITLE;
    @SerializedName("abstract")
    String ABSTRACT;
    @SerializedName("thumbnail_standard")
    String IMAGE;

    public TechArticle(String URL, String TITLE, String ABSTRACT, String IMAGE) {
        this.URL = URL;
        this.TITLE = TITLE;
        this.ABSTRACT = ABSTRACT;
        this.IMAGE = IMAGE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getABSTRACT() {
        return ABSTRACT;
    }

    public void setABSTRACT(String ABSTRACT) {
        this.ABSTRACT = ABSTRACT;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.URL);
        dest.writeString(this.TITLE);
    }

    protected TechArticle(Parcel in) {
        this.URL = in.readString();
        this.TITLE = in.readString();
    }

    public static final Creator<TechArticle> CREATOR = new Creator<TechArticle>() {
        @Override
        public TechArticle createFromParcel(Parcel source) {
            return new TechArticle(source);
        }

        @Override
        public TechArticle[] newArray(int size) {
            return new TechArticle[size];
        }
    };
}
