package com.ost.android2.MediaInventory;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class MediaInventoryDBHelper extends SQLiteOpenHelper {
    private static final int    DB_VERSION  = 2;
    private static final String DB_Name     = "MediaDB.db";
    private static final String TAG         = "MediaInventoryDBHelper";

    public MediaInventoryDBHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
      Log.d(TAG, "OnCreate(SQLiteDatabase db) called for version" + DB_VERSION);
      MediaInventoryTableContract.onCreate(db);   
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      Log.d(TAG, "OnUpgrade(SQLiteDatabase db) called to upgrade " + oldVersion + " + " + newVersion);
      MediaInventoryTableContract.onUpgrade(db, oldVersion, newVersion);        
    } // end of onUpgrade
    
} // end of DBHelper

