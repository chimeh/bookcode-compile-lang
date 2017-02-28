package com.ost.android2.MediaInventory;


import com.ost.android2.MediaInventory.R;
import com.ost.android2.MediaInventory.MediaInventoryContentProvider;

import android.support.v4.app.FragmentManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MediaFragment extends Fragment  {
  private static final String TAG = "MediaFragment";
  private static final String DIALOG_SUBTYPE = "subtype";
  private static final String DIALOG_TYPE    = "type";
  private static final int REQUEST_TYPE=0; 
  private static final int REQUEST_SUBTYPE=1;  
  protected Activity mActivity;

  private EditText   mTitle;
  private EditText   mArtist;
  private TextView   mType;
  private TextView   mSubType;
  private EditText   mGenre;
  private EditText   mPublisher;
  private EditText   mYear;
  private EditText   mLanguage;
  private EditText   mCountry;
  private EditText   mCatalogId;
  private Button     mTypeButton;
  private Button     mSubTypeButton;
  private Button     mUpdateButton;
  private Button     mURLListButton;
  private Uri        mediaUri; 


  private MediaInventoryData mData;
  private ContentValues      mValues; 
  
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "enter OnCreate()"); 
    setRetainInstance(true);
 
    mActivity = getActivity();
    mValues = new ContentValues(); 
    mData = new MediaInventoryData();
    
    Bundle extras = getActivity().getIntent().getExtras();

    mediaUri = (savedInstanceState == null) ? null : (Uri) savedInstanceState.getParcelable(MediaInventoryContentProvider.CONTENT_ITEM_TYPE);  
 
    if (extras != null) {
      mediaUri = extras.getParcelable(MediaInventoryContentProvider.CONTENT_ITEM_TYPE);
      getMediaData(mediaUri, mData);
    } 
    
   if (mediaUri != null) {
    Log.d(TAG, "exit OnCreate()  mediaUri= " + mediaUri);
   }
   

  }
  
 @Override
 public void onSaveInstanceState(Bundle outState) {
   super.onSaveInstanceState(outState);
   buildMediaData(mValues, mData);
   outState.putParcelable(MediaInventoryContentProvider.CONTENT_ITEM_TYPE, mediaUri);

 }

 
  @Override
  public void onPause() {
    super.onPause();
    buildMediaData(mValues, mData);
  }
   
  

  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedinstanceState) {
    Log.d(TAG, "OnCreateView() called"); 
    View v = inflater.inflate(R.layout.fragment_media, parent, false);
    
    mTitle = (EditText) v.findViewById(R.id.media_title);
    mTitle.setText(mData.getTitle());
    mTitle.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setTitle(c.toString().trim());     
        }
    });    
    
    
    mArtist = (EditText) v.findViewById(R.id.media_artist);
    mArtist.setText(mData.getArtist());
    mArtist.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
           mData.setArtist(c.toString().trim());  
        }
    });    
    
    
    mType = (TextView) v.findViewById(R.id.media_type);
    mType.setText(mData.getType());
    
    mTypeButton = (Button) v.findViewById(R.id.type_button);
    mTypeButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          FragmentManager fm = getActivity().getSupportFragmentManager();
          TypeChoiceFragment dialog = TypeChoiceFragment.newInstance(mData.getType());
          dialog.setTargetFragment(MediaFragment.this, REQUEST_TYPE);
          dialog.show(fm, DIALOG_TYPE);
        }
    });
    
    mSubType = (TextView) v.findViewById(R.id.media_subtype);
    mSubType.setText(mData.getSubType());
    
    mSubTypeButton = (Button) v.findViewById(R.id.subtype_button);
    mSubTypeButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          FragmentManager fm = getActivity().getSupportFragmentManager();
          SubTypeChoiceFragment dialog = SubTypeChoiceFragment.newInstance(mData.getSubType());
          dialog.setTargetFragment(MediaFragment.this, REQUEST_SUBTYPE);          
          dialog.show(fm, DIALOG_SUBTYPE);
        }
    });
    
 
    
    mGenre = (EditText) v.findViewById(R.id.media_genre);
    mGenre.setText(mData.getGenre());
    mGenre.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setGenre(c.toString().trim());          
        }
    });    
    
    
    mLanguage = (EditText) v.findViewById(R.id.media_language);
    mLanguage.setText(mData.getLanguage());
    mLanguage.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setLanguage(c.toString().trim());          
        }
    });   

    
    mCountry = (EditText) v.findViewById(R.id.media_country);
    mCountry.setText(mData.getCountry());
    mCountry.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setCountry(c.toString().trim());          
        }
    });   
    
    
    mPublisher = (EditText) v.findViewById(R.id.catalog_publisher);
    mPublisher.setText(mData.getPublisher());
    mPublisher.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setPublisher(c.toString().trim());          
        }
    });    
    
    
    mYear = (EditText) v.findViewById(R.id.catalog_year);
    mYear.setFilters(new InputFilter[] {
    		new InputFilter.LengthFilter(2)
    });
    String year = Integer.toString(mData.getYear());
    mYear.setText(year); 
    mYear.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {
        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {

             if (mYear.length() == 4) {
                 mData.setYear(Integer.parseInt((c.toString().trim())));
             } 
          }
    });    
    
    
    
    mCatalogId = (EditText) v.findViewById(R.id.catalog_id);
    mCatalogId.setText(mData.getCatalogID());
    mCatalogId.addTextChangedListener(new TextWatcher() {
        public void onTextChanged(CharSequence c, int start, int before, int count) {

        }
        public void beforeTextChanged(CharSequence c, int start, int count, int after) {
          
        }
        public void afterTextChanged(Editable c) {
          mData.setCatalogID(c.toString().trim());          
        }
    });    

    
    mUpdateButton = (Button) v.findViewById(R.id.update_button);
    mUpdateButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          buildMediaData(mValues, mData);
          getActivity().finish();
        }
    });
    
    mURLListButton = (Button) v.findViewById(R.id.url_list_button);
    mURLListButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Log.d(TAG, "mURLListButton handler found media id="  + mData.getmId());
            
        	 Intent i = new Intent(getActivity(), MediaURLListActivity.class);
             i.putExtra(MediaInventoryTableContract.C_ID,     mData.getmId()); 
             i.putExtra(MediaInventoryTableContract.C_ARTIST, mData.getArtist()); 
             i.putExtra(MediaInventoryTableContract.C_TITLE,  mData.getTitle()); 
             startActivityForResult(i, 0);
        }
    });

    
    return v;
   
  }
  
  
  
  
  
  public static MediaFragment newInstance() {
    Log.d(TAG, "MediaFragment newInstance called"); 
    MediaFragment fragment = new MediaFragment();
    return fragment;
  }

 
  
  
  public void buildMediaData(ContentValues mv, MediaInventoryData md) {
    Log.d(TAG, "buildmediaData() Called");
    
    if (md.getTitle() == null) {
    	return;
    }
    
    if (md.getmId() != 0) {
      mv.put(MediaInventoryTableContract.C_ID, md.getmId());
    }
        
    mv.put(MediaInventoryTableContract.C_TITLE,     md.getTitle());
    mv.put(MediaInventoryTableContract.C_ARTIST,    md.getArtist());   
    mv.put(MediaInventoryTableContract.C_MEDIUM,    md.getType());
    mv.put(MediaInventoryTableContract.C_SUBTYPE,   md.getSubType());
    mv.put(MediaInventoryTableContract.C_GENRE,     md.getGenre());   
    mv.put(MediaInventoryTableContract.C_COUNTRY,   md.getCountry());   
    mv.put(MediaInventoryTableContract.C_LANGUAGE,  md.getLanguage());
    mv.put(MediaInventoryTableContract.C_YEAR,      md.getYear());
    mv.put(MediaInventoryTableContract.C_PUBLISHER, md.getPublisher());
    mv.put(MediaInventoryTableContract.C_CID,       md.getCatalogID());
    
    
    Log.d(TAG, "....Update button OnClickListener, Ready to get Content resolver for : " + mData.getTitle());

    if (mediaUri == null) {
      mediaUri = mActivity.getContentResolver().insert(MediaInventoryContentProvider.CONTENT_URI, mv);
     Log.d(TAG, "...Added SQL Data, mediaUri is now " + mediaUri);
    } else {
      mActivity.getContentResolver().update(mediaUri, mv, null,null);
      Log.d(TAG, "....Updated SQL Data for item: " + mediaUri); 

    }
   
    Log.d(TAG, "....buildmediaData() Returning");

  }

   
  
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.d(TAG, "onActivityResult() Called");
    if   (resultCode != Activity.RESULT_OK) {
      return;
    }
    
    if (requestCode == REQUEST_TYPE) {
      String type = (String)data.getSerializableExtra(TypeChoiceFragment.EXTRA_TYPE);
      mData.setType(type);
      updateType();
    }
    
    if (requestCode == REQUEST_SUBTYPE) {
      String subtype = (String)data.getSerializableExtra(SubTypeChoiceFragment.EXTRA_SUBTYPE);
      mData.setSubType(subtype);
      updateSubType();
    }
  } // end of on Activity result 
  
  public void updateType() {
    mType.setText(mData.getType().toString());
  }
  public void updateSubType() {
    mSubType.setText(mData.getSubType().toString());
  }


 
  public void getMediaData(Uri uri, MediaInventoryData md)  {
    Log.d(TAG, "getMediadata() called with Uri " + uri);
    Cursor cursor = mActivity.getContentResolver().query(uri,null, null, null, null);
    if (cursor!=null) {
      cursor.moveToFirst();
 
      int mId = (cursor.getInt(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_ID)));
      md.setmId(mId);
      Log.d(TAG, "getMediadata() found media with id " + mId + "/" + md.getmId());
      
      md.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_TITLE)));
      md.setArtist(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_ARTIST)));
      md.setType(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_MEDIUM)));
      md.setSubType(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_SUBTYPE)));
      md.setGenre(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_GENRE)));
      md.setCountry(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_COUNTRY)));
      md.setLanguage(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_LANGUAGE)));
      md.setYear(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_YEAR))));
      md.setPublisher(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_PUBLISHER)));
      md.setCatalogID(cursor.getString(cursor.getColumnIndexOrThrow(MediaInventoryTableContract.C_CID)));

     cursor.close(); 
    }
  }
  
}
