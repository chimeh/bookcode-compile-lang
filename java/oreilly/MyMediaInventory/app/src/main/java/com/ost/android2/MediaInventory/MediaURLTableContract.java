package com.ost.android2.MediaInventory;
 
  import android.database.sqlite.SQLiteDatabase;
  import android.util.Log;

  public class  MediaURLTableContract  {
      private static final String TAG         = "MediaURLTableContract";
      
      public static String getTableUrl() {
        return TABLE_URL;
      }

      
      public static String getcId() {
        return C_ID;
      }

      public static final String C_ID        = "_id";
      public static final String C_MEDIAID   = "mediaId";
      public static final String C_URL       = "url";
      public static final String C_URLDESC   = "urldesc";
      

      private static final String TABLE_URL   = "mediaURL";
      
      private static final String DATABASE_CREATE = "CREATE TABLE "
          + TABLE_URL + "( "  
          + C_ID               + " integer primary key autoincrement, " 
          + C_MEDIAID          + " integer, " 
          + C_URL              + " text, " 
          + C_URLDESC          + " text" + ");";
     

      public static void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "OnCreate(SQLiteDatabase db) creating " + TABLE_URL);
        db.execSQL(DATABASE_CREATE);
      }   
  
      public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "OnUpgrade(SQLiteDatabase db) called to convert " + TABLE_URL + " from " +oldVersion + " to " + newVersion );
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_URL + ";");
          onCreate(db);
      } // end of onUpgrade
 } // end of MediaURLTableContract


