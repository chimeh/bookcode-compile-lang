package com.ost.android2.MediaInventory;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MediaActivity extends FragmentContainerActivity {
  private static final String TAG = "MediaActivity";

  @Override
  protected Fragment createFragment() {
      Log.d(TAG, "createFragment() called "); 
      return MediaFragment.newInstance();
  } // end of createFragment
  
 

} //end of Class