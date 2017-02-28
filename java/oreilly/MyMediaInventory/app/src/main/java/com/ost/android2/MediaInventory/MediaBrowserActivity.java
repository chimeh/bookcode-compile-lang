package com.ost.android2.MediaInventory;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MediaBrowserActivity extends FragmentContainerActivity {
  private static final String TAG = "MediaBrowserActivity";

  @Override
  protected Fragment createFragment() {
      Log.d(TAG, "createFragment() called "); 
      return MediaBrowserFragment.newInstance();
  } // end of createFragment
  
 

} //end of Class