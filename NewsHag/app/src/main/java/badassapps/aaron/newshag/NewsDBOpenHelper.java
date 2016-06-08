package badassapps.aaron.newshag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tiannan.mcclanahan on 6/1/16.
 */

//Our favorites database (added by: Aaron on 6/2/2016)

public class NewsDBOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 17;
    public static final String DATABASE_NAME = "News.db";
    public static final String NEWS_HAG_TABLE = "Saved_Stories";
    public static final String FAVS_HAG_TABLE = "Fav_Stories";

    public static final String COL_ID = "_id";
    public static final String COL_URL = "level";
    public static final String COL_FAV = "favorites";
    public static final String COL_TITLE = "name";
    public static final String COL_THUMBNAIL = "thumbnail";
    public static final String COL_ABSTRACT = "realm";



    public NewsDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int
            version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                NEWS_HAG_TABLE + "("
                + COL_ID + " INTEGER PRIMARY KEY," + COL_URL
                + " TEXT, "+ COL_FAV + " INTEGER," + COL_TITLE + " TEXT, " + COL_THUMBNAIL +
                " TEXT, " + COL_ABSTRACT + " TEXT)";

        String CREATE_FAV_TABLE = "CREATE TABLE " +
                FAVS_HAG_TABLE + "("
                + COL_ID + " INTEGER PRIMARY KEY," + COL_URL
                + " TEXT, "+ COL_FAV + " INTEGER," + COL_TITLE + " TEXT, " + COL_THUMBNAIL +
                " TEXT, " + COL_ABSTRACT + " TEXT)";

        db.execSQL(CREATE_PRODUCTS_TABLE);
        db.execSQL(CREATE_FAV_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NEWS_HAG_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FAVS_HAG_TABLE);
        onCreate(db);
    }

    private void deleteItem() {


            SQLiteDatabase db = NewsDBOpenHelper.this.getReadableDatabase();
            db.delete(FAVS_HAG_TABLE, NewsDBOpenHelper.COL_ID + " = ?", null);


    }



    public long addArticle(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long insertedRow = db.insert(NEWS_HAG_TABLE, null, values);
        return insertedRow;
    }

    public long addFavorite(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long updateRow = db.update(NEWS_HAG_TABLE, null, COL_FAV + " = ?", new String[]{"1"});
        return updateRow;
    }

    public long removeFav(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long RemoveRow = db.update(NEWS_HAG_TABLE, null, COL_FAV + " = ?", new String[]{"0"});
        return RemoveRow;
    }



    public Cursor getAllArticles() {
        String[] projection = {COL_ID, COL_URL, COL_FAV, COL_TITLE, COL_THUMBNAIL, COL_ABSTRACT};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NEWS_HAG_TABLE,projection,null,null,null,null,null);
        return cursor;

    }

    public Cursor getFavorites(){
        String[] projection = {COL_ID, COL_URL, COL_FAV, COL_TITLE, COL_THUMBNAIL, COL_ABSTRACT};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                FAVS_HAG_TABLE,projection, COL_FAV + " = ?", new String[]{"1"},
                null,null,null);
        return cursor;
    }

    public Cursor removeFav(){
        String[] projection = {COL_ID, COL_URL, COL_FAV, COL_TITLE, COL_THUMBNAIL, COL_ABSTRACT};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                FAVS_HAG_TABLE,projection, COL_FAV + " = ?", new String[]{"0"},
                null,null,null);
        return cursor;
    }



    public int deleteAllArticles() {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete(NEWS_HAG_TABLE,null,null);
        return rowsDeleted;
    }

    @Override
    public synchronized void close() {
        super.close();

    }


}


