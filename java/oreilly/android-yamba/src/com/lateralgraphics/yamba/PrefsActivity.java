package com.lateralgraphics.yamba;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class PrefsActivity extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Like any other activity, we override onCreate() to initialise activity
		super.onCreate(savedInstanceState);
		// Unlike regular activities that usually call: setContentView(), this will set it's content from addPreferencesFromResource()
		addPreferencesFromResource(R.xml.prefs);
	}
}
