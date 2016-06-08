package badassapps.aaron.newshag;

/**
 * Created by aaron on 6/2/2016.
 */

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class AppContentProvider extends ContentProvider{


    private NewsDBOpenHelper myDB;
    private static final String AUTHORITY = "badassapps.aaron.newshag.AppContentProvider";
    private static final String ARTICLES_TABLE = "articles";
    public static final Uri CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + ARTICLES_TABLE);
    public static final Uri FAVORITES_URI = Uri.parse("content://"
            + AUTHORITY + "/" + ARTICLES_TABLE + "/favorites");

    public static final int ARTICLES = 1;
    public static final int FAVORITES = 2;
    public static final int REMOVE_FAVORITES = 3;

    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, ARTICLES_TABLE, ARTICLES);
        sURIMatcher.addURI(AUTHORITY, ARTICLES_TABLE + "/favorites", FAVORITES);

    }
    /*
     * Always return true, indicating that the
     * provider loaded correctly.
     */
    @Override
    public boolean onCreate() {
        myDB = new NewsDBOpenHelper(getContext(), null, null, 1);
        return false;

    }


    /*
     * Return no type for MIME type
     */
    @Override
    public String getType(Uri uri) {
        return null;
    }
    /*
     * query() always returns no results
     *
     */
    @Override
    public Cursor query(
            Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        switch (uriType) {
            //Most specific at the top, more general at the bottom :-> Dependent upon the pattern you're using
            case ARTICLES:
                cursor = myDB.getAllArticles();
                break;
            case FAVORITES:
                cursor = myDB.getFavorites();
                break;
            case REMOVE_FAVORITES:
                cursor = myDB.removeFav();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }
    /*
     * insert() always returns null (no URI)
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case ARTICLES:
                id = myDB.addArticle(values);
                break;
            case FAVORITES:
                id = myDB.addFavorite(values);
            case REMOVE_FAVORITES:
                id = myDB.removeFav(values);

                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        //Step 2. Resolver will notify a change and our observer will make the modifications
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(ARTICLES_TABLE + "/" + id);
    }
    /*
     * delete() always returns "no rows affected" (0)
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = sURIMatcher.match(uri);
        int rowsDeleted = 0;

        switch (uriType) {
            case ARTICLES:
                rowsDeleted = myDB.deleteAllArticles();
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return rowsDeleted;
    }
    /*
     * update() always returns "no rows affected" (0)
     */
    public int update(
            Uri uri,
            ContentValues values,
            String selection,
            String[] selectionArgs) {
        return 0;
    }
}
