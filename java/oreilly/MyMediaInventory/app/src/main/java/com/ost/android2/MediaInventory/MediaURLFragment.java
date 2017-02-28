package com.ost.android2.MediaInventory;


import com.ost.android2.MediaInventory.R;
import com.ost.android2.MediaInventory.MediaURLContentProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MediaURLFragment extends Fragment  {
  private static final String TAG = "MediaURLFragment";
  protected Activity mActivity;

  private EditText   mURL, mDescription;
  private Button     mUpdateButton;
  private Button     mDisplayButton;
  private Uri        mediaURLuri; 

  public    int mMediaId;
  public    String mTitle, mArtist;

  private MediaURLData  mData;
  private ContentValues mValues; 
  private   Intent intent;
  
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "enter OnCreate()"); 
    setRetainInstance(true);
 
    mActivity = getActivity();
    mValues = new ContentValues(); 
    mData = new MediaURLData();
    
    mediaURLuri = (savedInstanceState == null) ? null : 
    	(Uri) savedInstanceState.getParcelable(MediaURLContentProvider.CONTENT_ITEM_TYPE);  

    Bundle extras = getActivity().getIntent().getExtras();
    if (extras != null) {
      mediaURLuri = extras.getParcelable(MediaURLContentProvider.CONTENT_ITEM_TYPE);
      mMediaId    = extras.getInt(MediaInventoryTableContract.C_ID); 
      mArtist     = extras.getString(MediaInventoryTableContract.C_ARTIST);
      mTitle      = extras.getString(MediaInventoryTableContract.C_TITLE);
      String tString = getResources().getString(R.string.url_upd_title);
      mActivity.setTitle(tString + " for " + mTitle + " with " + mArtist);
      mData.setuMId(mMediaId);
      Log.d(TAG, "onCreate() found " + mMediaId + ", " + mArtist + ", " + mTitle);


    } else {
        Log.d(TAG, "onCreate() extras missing"); 
    	
    }
    
   if (mediaURLuri != null) {
	   getURLData(mediaURLuri, mData);
       Log.d(TAG, "exit OnCreate()  mediaURLuri= " + mediaURLuri);
   } else {
       Log.d(TAG, "onCreate() uri missing"); 
   	
   }
   

  }
  
 @Override
 public void onSaveInstanceState(Bundle outState) {
   super.onSaveInstanceState(outState);
   buildURLData(mValues, mData);
   outState.putParcelable(MediaURLContentProvider.CONTENT_ITEM_TYPE, mediaURLuri);

 }

 
  @Override
  public void onPause() {
    super.onPause();
    buildURLData(mValues, mData);
  }
   
  

  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedinstanceState) {
    Log.d(TAG, "OnCreateView() called"); 
    View v = inflater.inflate(R.layout.fragment_media_url, parent, false);
    
    mURL = (EditText) v.findViewById(R.id.media_url);
    mURL.setText(mData.getInfoURL());
    mURL.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setInfoURL(c.toString().trim());     
    }
    });    
    
    
    mDescription = (EditText) v.findViewById(R.id.media_url_desc);
    mDescription.setText(mData.getInfoURLDesc());
    mDescription.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
           mData.setInfoURLDesc(c.toString().trim());  
        }
    });    
    

    
    mUpdateButton = (Button) v.findViewById(R.id.update_url_button);
    mUpdateButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
           String mURLFull = mData.getInfoURL();
     	   if (mURLFull.length() > 3) {
     		   String hComp = mURLFull.substring(0,4); 
        	    if (!hComp.equals("http")) {
        	        mURLFull = "http://" + mURLFull;
        	        mData.setInfoURL(mURLFull);
        	    } 
     	   }
     	    
     	    if (!URLUtil.isValidUrl(mData.getInfoURL())) {
     	        Toast.makeText(getActivity(),  " Invalid URL " + mData.getInfoURL(),Toast.LENGTH_LONG).show();
     	    }    
          buildURLData(mValues, mData);
          getActivity().finish();
        }
    });
    
    mDisplayButton = (Button) v.findViewById(R.id.display_url_button);
    mDisplayButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            intent = new Intent(getActivity(), MediaBrowserActivity.class);
            intent.putExtra(MediaURLTableContract.C_URL,           mData.getInfoURL()); 
            intent.putExtra(MediaInventoryTableContract.C_ARTIST,  mArtist  );
            intent.putExtra(MediaInventoryTableContract.C_TITLE,   mTitle );
            Log.d(TAG, "Browser activity will start"); 
         	  startActivityForResult(intent,0);
        }
    });

    
    return v;
   
  }

  
  public static MediaURLFragment newInstance() {
    Log.d(TAG, "MediaURLFragment newInstance called"); 
    MediaURLFragment fragment = new MediaURLFragment();
    return fragment;
  }

 
  
  
  public void buildURLData(ContentValues mv, MediaURLData md) {
    Log.d(TAG, "buildURLData() Called");

    if ((md.getInfoURL() == null) || (md.getuMId() == 0)  ) {
    	return;
    }
    
    if (md.getuId() != 0) {
      mv.put(MediaURLTableContract.C_ID, md.getuId());
    }
    
    if (md.getuMId() != 0) {
        mv.put(MediaURLTableContract.C_MEDIAID, md.getuMId());
    }
    
 
    if (md.getInfoURL() != null) { 
    	mv.put(MediaURLTableContract.C_URL,  md.getInfoURL());
    }
   
    if (md.getInfoURLDesc() != null) { 
    	mv.put(MediaURLTableContract.C_URLDESC,  md.getInfoURLDesc());
    }
    
    Log.d(TAG, "....Update button OnClickListener, Ready to get Content resolver for : " + mData.getInfoURL());

    if (mediaURLuri == null) {
      mediaURLuri = mActivity.getContentResolver().insert(MediaURLContentProvider.CONTENT_URI, mv);
     Log.d(TAG, "...Added SQL Data, mediaURLuri is now " + mediaURLuri);
    } else {
      mActivity.getContentResolver().update(mediaURLuri, mv, null,null);
      Log.d(TAG, "....Updated SQL Data for item: " + mediaURLuri); 

    }
   
    Log.d(TAG, "....buildURLData() Returning");

  }

   
  
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(TAG, "onActivityResult() Called");
    if   (resultCode != Activity.RESULT_OK) {
      return;
    }
    
  } // end of on Activity result 
  


 
  public void getURLData(Uri uri, MediaURLData md)  {
    Log.d(TAG, "getURLData() called with Uri " + uri);
    Cursor cursor = mActivity.getContentResolver().query(uri,null, null, null, null);
    if (cursor!=null) {
      cursor.moveToFirst();
      
      md.setuId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(MediaURLTableContract.C_ID))));
      md.setuMId(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(MediaURLTableContract.C_MEDIAID))));
      md.setInfoURL(cursor.getString(cursor.getColumnIndexOrThrow(MediaURLTableContract.C_URL)));
      md.setInfoURLDesc(cursor.getString(cursor.getColumnIndexOrThrow(MediaURLTableContract.C_URLDESC)));

     cursor.close(); 
    }
  }
  
}
