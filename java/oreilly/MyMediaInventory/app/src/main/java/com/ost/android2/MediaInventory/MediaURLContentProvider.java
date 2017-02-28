package com.ost.android2.MediaInventory;


import java.util.Arrays;
import java.util.HashSet;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import com.ost.android2.MediaInventory.MediaURLDBHelper;

public class MediaURLContentProvider extends ContentProvider {
	
  private static String TAG ="MediaURLContentprovider";
  
  public static final String AUTHORITY     = "com.ost.android2.MediaURL.contentprovider";
  public static final Uri BASE_CONTENT_URI = 
		  new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).build();
  public static final String BASE_PATH     = MediaURLTableContract.getTableUrl();
  
  public static final int ALL_ITEMS   = 30;
  public static final int SINGLE_ITEM = 40; 

  public static final Uri    CONTENT_URI       = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
  public static final String CONTENT_TYPE      = ContentResolver.CURSOR_DIR_BASE_TYPE  + "/" +  MediaURLTableContract.getTableUrl();
  public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + "urlID";
  
  
  public static UriMatcher sUriMatcher = new UriMatcher (UriMatcher.NO_MATCH);
  static {
    sUriMatcher.addURI(AUTHORITY, BASE_PATH, ALL_ITEMS);
    sUriMatcher.addURI(AUTHORITY, BASE_PATH +  "/#", SINGLE_ITEM);
  } 
  
   private MediaURLDBHelper mDBHelper;

    @Override
    public boolean onCreate() {
        mDBHelper = new MediaURLDBHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
    	Log.d(TAG, "Cursor called");
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        checkColumns(projection);
        queryBuilder.setTables(MediaURLTableContract.getTableUrl());        
        
        
        int uriType = sUriMatcher.match(uri);
        switch (uriType) {
        case ALL_ITEMS:
          break;
        case SINGLE_ITEM:
          queryBuilder.appendWhere(MediaURLTableContract.C_ID + "=" + uri.getLastPathSegment());
          break;
        default: throw new IllegalArgumentException("Unnown URI: " + uri);  
        }
        
        
        SQLiteDatabase db =  mDBHelper.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;

        }
  
  
    private void checkColumns(String[] projection) {
      String[] available = {
          MediaURLTableContract.C_ID,
          MediaURLTableContract.C_MEDIAID,    
          MediaURLTableContract.C_URLDESC,  
          MediaURLTableContract.C_URL      
      };
      if (projection != null) {
        HashSet<String> requestedColumns = new HashSet<String>(Arrays.asList(projection));
        HashSet<String> availableColumns = new HashSet<String>(Arrays.asList(available));
        if (!availableColumns.containsAll(requestedColumns)) {
          throw new IllegalArgumentException("Unknown Columns In Projection");
          
        }
      }  
     
    }
    
    
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
      
        long id=0;
        
        int uriType = sUriMatcher.match(uri);
        switch (uriType) {
        case ALL_ITEMS:
           id = db.insert(MediaURLTableContract.getTableUrl(), null, values);
          break;
        default: throw new IllegalArgumentException("Unknown URI: " + uri);  
        }
       
        //* In order for MediaFragment to avoid multiple adds of the same record 
        //* if orientation changes and also
        //* to allow update, after it is added on same panel
        //* the uri must be returned with the id and the insert call in MediaFragment
        //* must accept this by assigning the the uri variable in use there
        if (id > -1) {
            ContentResolver resolver = getContext().getContentResolver();
            resolver.notifyChange(uri, null);
            return Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH + "/" + id); 
        } else {
            Log.d(TAG, "Insert failed");
            return null;
        }

    }
    
    
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
   
        int rowsDeleted = 0; 
        String id = null;
        
        int uriType = sUriMatcher.match(uri);     
        switch (uriType) {
        case ALL_ITEMS:
        	Log.d(TAG, "Logic problem - Should not be trying to delete all");
        	throw new IllegalArgumentException("Problematic URI:" + uri);
        case SINGLE_ITEM:
          id = uri.getLastPathSegment();
      
            rowsDeleted =  db.delete(MediaURLTableContract.getTableUrl(), MediaURLTableContract.getcId() + "=" + id, null);
            ContentResolver resolver = getContext().getContentResolver();
            resolver.notifyChange(uri, null);

         break;
        default: throw new IllegalArgumentException("Unknown URI: " + uri);  
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        
        int rowsUpdated = 0; 
        String id = null;
        
      
        int uriType = sUriMatcher.match(uri);     
        switch (uriType) {
        case ALL_ITEMS:
        	Log.d(TAG, "Logic problem - Should not be trying to update all");
        	throw new IllegalArgumentException("Problematic URI:" + uri);
        case SINGLE_ITEM	:
          id = uri.getLastPathSegment();

            rowsUpdated =  db.update(MediaURLTableContract.getTableUrl(), values, 
            		MediaURLTableContract.getcId()+ "=" + id, null);

         break;
        default: throw new IllegalArgumentException("Unknown URI: " + uri);  
        }
        return rowsUpdated;
        
    }    
}
