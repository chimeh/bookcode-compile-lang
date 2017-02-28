package com.ost.android2.MediaInventory;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MediaListActivity extends FragmentContainerActivity {
  private static final String TAG = "MediaListActivity";
  @Override
  protected Fragment createFragment() {
    Log.d(TAG, "createFragment() called"); 
    return new MediaListFragment();
  } // end of createFragment

} // end of Class