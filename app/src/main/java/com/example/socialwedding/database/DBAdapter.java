package com.example.socialwedding.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.net.URLConnection;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_TITLE = "title";
    static final String KEY_BODY = "body";
    static final String KEY_LIKECOUNT = "likecount";
    static final String KEY_IMAGEID = "imageid";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "Weddings";
    static final String DATABASE_TABLE = "weddings";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE =

            "create table weddings (_id integer primary key autoincrement, "
            + "title text not null, body text not null, likecount integer not null, imageid integer not null);";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.w(TAG, "I dont think this is working");
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                Log.w(TAG, "table is created wtf");
                db.execSQL(DATABASE_CREATE);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version"  + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        Log.w(TAG, "Database is opened");
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public void createTable() throws SQLException {
        db.execSQL(DATABASE_CREATE);
    }
    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }
    //---insert a contact into the database---
    public long insertWedding(String title, String body, int likeCount, int imageId)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_BODY, body);
        initialValues.put(KEY_LIKECOUNT, likeCount);
        initialValues.put(KEY_IMAGEID, imageId);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    //---deletes a particular contact---
    public boolean deletePost(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public boolean clearDatabase() {
       return context.deleteDatabase(DATABASE_NAME);
    }
    //---retrieves all the contacts---
    public Cursor getAllWeddings()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE, KEY_BODY, KEY_LIKECOUNT, KEY_IMAGEID}, null, null, null, null, null);
    }
    //---retrieves a particular contact---
    public Cursor getPost(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                                KEY_TITLE, KEY_BODY, KEY_LIKECOUNT, KEY_IMAGEID}, KEY_ROWID + "=" + rowId, null,
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    //---updates a contact---
    public boolean updatePost(long rowId, String title, String body, int likeCount, int imageId)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_TITLE, title);
        args.put(KEY_BODY, body);
        args.put(KEY_LIKECOUNT, likeCount);
        args.put(KEY_IMAGEID, imageId);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
