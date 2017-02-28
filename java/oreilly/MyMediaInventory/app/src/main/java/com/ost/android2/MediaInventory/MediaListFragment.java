package com.ost.android2.MediaInventory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.CursorLoader;
import android.widget.SimpleCursorAdapter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.database.Cursor;

import com.ost.android2.MediaInventory.R;
import com.ost.android2.MediaInventory.MediaInventoryTableContract;

public class MediaListFragment extends ListFragment implements LoaderCallbacks<Cursor>{
  private static final String TAG = "MediaListFragment";
  
  private static final int DBACTION_ADD   = 0;
  private static final int DBACTION_UPDATE = 1;
  
  private   Intent intent;
  public    SimpleCursorAdapter mAdapter;
  protected Activity mActivity;
  public    SharedPreferences sharedpreferences;
  public    Boolean aSort ,selBooks, selMovies, selMusic;
  public    CursorLoader cursorLoader;
  
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
    setHasOptionsMenu(true);
    Log.d(TAG, "OnCreate(Bundle) called"); 
    mActivity = getActivity();
    mActivity.setTitle(R.string.medialist_title);
    getPrefs();
    getLoaderManager().restartLoader(0, null, this);
   
  } // end of onCreate
  
  
  @Override
  public void onResume()
  {
      super.onResume();
      Log.d(TAG, "onResume");
      getPrefs();
      getLoaderManager().restartLoader(0, null, this);

  }
  
  public void getPrefs() {
      SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
      aSort     = prefs.getBoolean("authorSort", false); 
      selBooks  = prefs.getBoolean("books",  false);
      selMovies = prefs.getBoolean("movies", false);
      selMusic  = prefs.getBoolean("music",  false);
    
      Log.d(TAG, "Author Sort is " + selBooks); 
      Log.d(TAG, "books selection is "    + selBooks); 
      Log.d(TAG, "music selection is "    + selMusic);
      Log.d(TAG, "movies selection is "   + selMovies); 
  }
  
  @Override
  public void onActivityCreated(Bundle savedinstanceState) {
    super.onActivityCreated(savedinstanceState);
    Log.d(TAG, "onActivityCreated() called"); 
    getLoaderManager().initLoader(0, null, this).forceLoad();
    registerForContextMenu(getListView());
  }

  @Override  
  public void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    Log.d(TAG, position + " was clicked,id=" + id);
    Intent i = new Intent(getActivity(), MediaActivity.class);
    Uri itemUri = Uri.parse(MediaInventoryContentProvider.CONTENT_URI + "/" + id );
    i.putExtra(MediaInventoryContentProvider.CONTENT_ITEM_TYPE, itemUri);
    startActivityForResult(i, DBACTION_UPDATE);
  }
  
  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater ) {
      super.onCreateOptionsMenu(menu, inflater);
      Log.d(TAG, "onCreateOptionsMenu() called"); 
      inflater.inflate(R.menu.media_pref, menu);
  }
  
  @Override
  public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo cmi) {
     getActivity().getMenuInflater().inflate(R.menu.delete_item_context, menu);
  }

 @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      Log.d(TAG, "onOptionsItemSelected() called for item " + item); 

      switch (item.getItemId()) {
          case R.id.mi_pref:
            intent = new Intent(getActivity(), MediaPreferenceActivity.class);  
            Log.d(TAG, "Media filter preferences activity will start"); 
            startActivityForResult(intent, 0);

              break;
          case R.id.mi_new_item:
              intent = new Intent(getActivity(), MediaActivity.class);
              Log.d(TAG, "Media item add activity will start"); 
           	  startActivityForResult(intent, DBACTION_ADD);

               break;
          default:
            return super.onOptionsItemSelected(item);
      }
      
      return true;
  }
    
  @Override
  public boolean onContextItemSelected(MenuItem item) {
      Log.d(TAG, "onContextItemSelected() called");
      switch (item.getItemId()) {
          case R.id.mi_delete:
            AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
            Uri uri = Uri.parse(MediaInventoryContentProvider.CONTENT_URI + "/" + info.id);
            Log.d(TAG, "Uri=" + uri);
            mActivity.getContentResolver().delete(uri,null,null);
            break;
          default:
            return super.onContextItemSelected(item);
      }
      return true;
  } // end of onContextItemSelected


    @Override
    public Loader<Cursor> onCreateLoader(int od, Bundle args) {
      Log.d(TAG, "onCreateLoader() called");
      String[] projection =  {MediaInventoryTableContract.C_ID,  MediaInventoryTableContract.C_TITLE,  MediaInventoryTableContract.C_ARTIST};
      String selection = ""; 
       if(selBooks && selMovies && selMusic) {
    	    selection = null;
       } else if (selBooks && selMovies) {
        	selection = MediaInventoryTableContract.C_MEDIUM + " = \'Book\' OR "  +  MediaInventoryTableContract.C_MEDIUM + " = \'Movie\'";  
       } else if (selBooks && selMusic) {
 	        selection = MediaInventoryTableContract.C_MEDIUM + " = \'Book\' OR "  +  MediaInventoryTableContract.C_MEDIUM + " = \'Music\'";
       } else if (selMovies && selMusic) {
 	        selection = MediaInventoryTableContract.C_MEDIUM + " = \'Movie\' OR " +  MediaInventoryTableContract.C_MEDIUM + " = \'Music\'";     
       }else if (selBooks) {
    	    selection = MediaInventoryTableContract.C_MEDIUM + " = \'Book\'";  
       } else if (selMovies) {
 	       selection  = MediaInventoryTableContract.C_MEDIUM + " = \'Movie\'"; 
       } else if (selMusic) {
    	    selection = MediaInventoryTableContract.C_MEDIUM + " = \'Music\'";  
       }
       
       Log.d(TAG, "selection= " + selection);

      
      if (aSort) {
    	  cursorLoader = 
    	  new CursorLoader(getActivity(),MediaInventoryContentProvider.CONTENT_URI, projection,selection,null,MediaInventoryTableContract.C_ARTIST + " COLLATE LOCALIZED ASC");
      } else {
          cursorLoader = 
          new CursorLoader(getActivity(),MediaInventoryContentProvider.CONTENT_URI, projection,selection,null,MediaInventoryTableContract.C_TITLE + " COLLATE LOCALIZED ASC");
      }

      return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
         Log.d(TAG, "onLoadFinished() called");
      if (aSort) {
	      mAdapter = new SimpleCursorAdapter(getActivity(),
	    		  android.R.layout.simple_list_item_2,
	          cursor,
	          new String[] {MediaInventoryTableContract.C_ARTIST, MediaInventoryTableContract.C_TITLE},
	          new int[]  {android.R.id.text1, android.R.id.text2});
      } else {
	      mAdapter = new SimpleCursorAdapter(getActivity(),
	    		  android.R.layout.simple_list_item_2,
	          cursor,
	          new String[] {MediaInventoryTableContract.C_TITLE, MediaInventoryTableContract.C_ARTIST},
	          new int[]  {android.R.id.text1, android.R.id.text2});
      }
      setListAdapter(mAdapter); 
      
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
      Log.d(TAG, "onLoaderReset() called");
  	if(mAdapter!=null) { 
        mAdapter.changeCursor(null);
  	}	
	else
		Log.v(TAG,"OnLoadReset: mAdapter is null");
   }

  
 }  // end of Class
