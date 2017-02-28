package com.ost.android2.MediaInventory;

import android.support.v4.app.Fragment;
import android.util.Log;

public class MediaURLListActivity extends FragmentContainerActivity {
  private static final String TAG = "MediaURLListActivity";
  @Override
  protected Fragment createFragment() {
    Log.d(TAG, "createFragment() called"); 
    return new MediaURLListFragment();
  } // end of createFragment

} // end of Class