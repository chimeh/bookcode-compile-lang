package com.ost.android2.MediaInventory;
 
  import android.database.sqlite.SQLiteDatabase;
  import android.util.Log;

  public class  MediaInventoryTableContract  {
    
    public static String getTableMedia() {
      return TABLE_MEDIA;
    }
    
    public static String getCid() {
      return C_ID;
    }

      public static final String TAG         = "Media InventoryTableContract";
      public static final String TABLE_MEDIA = "mediaInventory";
      


      public static final String C_ID        = "_id";
      public static final String C_TITLE     = "title";
      public static final String C_ARTIST    = "artist";
      public static final String C_MEDIUM    = "medium";
      public static final String C_SUBTYPE   = "subtype";
      public static final String C_GENRE     = "genre";
      public static final String C_COUNTRY   = "country";
      public static final String C_LANGUAGE  = "language";
      public static final String C_YEAR      = "year";
      public static final String C_PUBLISHER = "publisher";
      public static final String C_CID       = "catalogId";
      

      private static final String DATABASE_CREATE = "CREATE TABLE "
          + TABLE_MEDIA + "( "  
          + C_ID               + " integer primary key autoincrement, " 
          + C_TITLE            + " text not null, " 
          + C_ARTIST           + " text not null, " 
          + C_MEDIUM           + " text not null, " 
          + C_SUBTYPE          + " text not null, " 
          + C_GENRE            + " text not null, "  
          + C_COUNTRY          + " text not null, " 
          + C_LANGUAGE         + " text not null, " 
          + C_YEAR             + " integer not null DEFAULT 0, " 
          + C_PUBLISHER        + " text not null, " 
          + C_CID              + " text" + ");";

      public static void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "OnCreate(SQLiteDatabase db) creating " + TABLE_MEDIA);
        db.execSQL(DATABASE_CREATE);
      }   
  
      public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "OnUpgrade(SQLiteDatabase db) called to convert " + TABLE_MEDIA + " from " +oldVersion + " to " + newVersion );
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIA + ";");
          onCreate(db);
      } // end of onUpgrade
 } // end of MediaInventoryTableContract


