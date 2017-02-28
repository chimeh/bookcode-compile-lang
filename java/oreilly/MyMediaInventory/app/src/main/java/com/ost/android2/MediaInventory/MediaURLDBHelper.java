package com.ost.android2.MediaInventory;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class MediaURLDBHelper extends SQLiteOpenHelper {
    private static final int    DB_VERSION  = 1;
    private static final String DB_Name     = "MediaURLDB.db";
    private static final String TAG         = "MediaURLDBHelper";

    public MediaURLDBHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
      Log.d(TAG, "OnCreate(SQLiteDatabase db) called");
      MediaURLTableContract.onCreate(db);   
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      Log.d(TAG, "OnUpgrade(SQLiteDatabase db) called");
      MediaURLTableContract.onUpgrade(db, oldVersion, newVersion);        
    } // end of onUpgrade
    
} // end of DBHelper

