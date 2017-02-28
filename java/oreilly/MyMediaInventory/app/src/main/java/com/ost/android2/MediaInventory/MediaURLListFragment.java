package com.ost.android2.MediaInventory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.ost.android2.MediaInventory.MediaURLTableContract;
import com.ost.android2.MediaInventory.MediaInventoryTableContract;

public class MediaURLListFragment extends ListFragment implements LoaderCallbacks<Cursor>{
  private static final String TAG = "MediaURLListFragment";
  
  private static final int DBACTION_ADD   = 0;
  private static final int DBACTION_UPDATE = 1;
  
  private   Intent intent;
  public    SimpleCursorAdapter mAdapter;
  protected Activity mActivity;
  public    CursorLoader cursorLoader;
  public    int mMediaId;
  public    String mTitle, mArtist;
  
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
    setHasOptionsMenu(true);
    Log.d(TAG, "OnCreate(Bundle) called"); 
    mActivity = getActivity();
    getExtras(); 
    getLoaderManager().restartLoader(0, null, this);
   
  } // end of onCreate
  
  
  @Override
  public void onResume()
  {
      super.onResume();
      Log.d(TAG, "onResume");
      getExtras(); 
      getLoaderManager().restartLoader(0, null, this);

  }
  
  public void getExtras() {
	  Bundle extras = getActivity().getIntent().getExtras();
      mMediaId    = extras.getInt(MediaInventoryTableContract.C_ID); 
      mArtist     = extras.getString(MediaInventoryTableContract.C_ARTIST);
      mTitle      = extras.getString(MediaInventoryTableContract.C_TITLE);
      String tString = getResources().getString(R.string.medialist_url_title);
      mActivity.setTitle(tString + " for " + mTitle + " with " + mArtist);
      Log.d(TAG, "getExtras() found " + mMediaId + ", " + mArtist + ", " + mTitle); 
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
    Log.d(TAG, position + " was clicked, URL id=" + id);
    intent  = new Intent(getActivity(), MediaURLActivity.class);
    Uri itemUri = Uri.parse(MediaURLContentProvider.CONTENT_URI + "/" + id );
    intent.putExtra(MediaURLContentProvider.CONTENT_ITEM_TYPE, itemUri);
    intent.putExtra(MediaInventoryTableContract.C_CID,     mMediaId); 
    intent.putExtra(MediaInventoryTableContract.C_ARTIST,  mArtist  );
    intent.putExtra(MediaInventoryTableContract.C_TITLE,   mTitle );
    startActivityForResult(intent, DBACTION_UPDATE);
  }
  
  //* create menu to add a URL for current media item
  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater ) {
      super.onCreateOptionsMenu(menu, inflater);
      Log.d(TAG, "onCreateOptionsMenu() called"); 
      inflater.inflate(R.menu.media_url_pref, menu);
  }
  
  //* create menu to delete current selected URL
  @Override
  public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo cmi) {
     getActivity().getMenuInflater().inflate(R.menu.delete_url_context, menu);
  }

 @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      Log.d(TAG, "onOptionsItemSelected() called for menu item " + item); 

      switch (item.getItemId()) {
      
          case R.id.mi_new_url:
              intent = new Intent(getActivity(), MediaURLActivity.class);
              intent.putExtra(MediaInventoryTableContract.C_ID,     mMediaId); 
              intent.putExtra(MediaInventoryTableContract.C_ARTIST,  mArtist  );
              intent.putExtra(MediaInventoryTableContract.C_TITLE,   mTitle );
              Log.d(TAG, "Media item URL add activity will start"); 
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
          case R.id.mi_url_delete:
            AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
            Uri uri = Uri.parse(MediaURLContentProvider.CONTENT_URI + "/" + info.id);
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
      String[] projection =  {MediaURLTableContract.C_ID,  MediaURLTableContract.C_MEDIAID, 
    		  MediaURLTableContract.C_URL, MediaURLTableContract.C_URLDESC};
      
      String selection = MediaURLTableContract.C_MEDIAID + " = " + mMediaId;  
     
       Log.d(TAG, "selection= " + selection);

            cursorLoader = 
          new CursorLoader(getActivity(),MediaURLContentProvider.CONTENT_URI, projection,selection,null,
        		  MediaURLTableContract.C_URLDESC + " COLLATE LOCALIZED ASC");


      return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
         Log.d(TAG, "onLoadFinished() called");
  
	      mAdapter = new SimpleCursorAdapter(
	    	  getActivity(),
	    	  android.R.layout.simple_list_item_2,
	          cursor,
	          new String[] {MediaURLTableContract.C_URLDESC, MediaURLTableContract.C_URL},
	          new int[]  {android.R.id.text1, android.R.id.text2}
	      );

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
