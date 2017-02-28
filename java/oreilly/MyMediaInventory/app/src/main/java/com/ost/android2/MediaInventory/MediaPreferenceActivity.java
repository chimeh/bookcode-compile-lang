package com.ost.android2.MediaInventory;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

public class MediaPreferenceActivity extends PreferenceActivity {
  private static final String TAG = "MediaPreferenceActivity";

  public static final String EXTRA_PREFERENCES =
      "com.ost.android2.MediaInventory.preferences";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate(Bundle) called"); 
        addPreferencesFromResource(R.xml.preferences);
        Log.d(TAG, "Preference edit complete"); 
    }
 
    

} //end of Class
