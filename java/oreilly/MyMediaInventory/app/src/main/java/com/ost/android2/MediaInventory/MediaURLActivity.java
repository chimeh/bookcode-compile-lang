package com.ost.android2.MediaInventory;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MediaURLActivity extends FragmentContainerActivity {
  private static final String TAG = "MediaURLActivity";

  @Override
  protected Fragment createFragment() {
      Log.d(TAG, "createFragment() called "); 
      return MediaURLFragment.newInstance();
  } // end of createFragment
  
 

} //end of Class