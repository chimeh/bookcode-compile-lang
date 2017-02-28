package com.ost.android2.MediaInventory;

import com.ost.android2.MediaInventory.R;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class FragmentContainerActivity extends FragmentActivity {
  protected abstract Fragment createFragment();

  protected int getLayoutResId() {
	  return R.layout.master_fragment;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());
    
    FragmentManager fm = getSupportFragmentManager(); 
    Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
    
    if (fragment == null) {
      fragment = createFragment();
      fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();        
    }
    
  }
}
