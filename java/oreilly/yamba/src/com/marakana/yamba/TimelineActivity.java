package com.marakana.yamba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;

public class TimelineActivity extends BaseActivity {

	Cursor cursor;
	ListView listTimeline;
	YambaApplication yamba;
	SimpleCursorAdapter adapter;
	TimelineReceiver receiver;
	IntentFilter filter;
	
	static final String[] FROM = {StatusData.C_CREATED_AT, StatusData.C_USER, StatusData.C_TEXT};
	static final int[] TO = {R.id.textCreatedAt, R.id.textUser, R.id.textText};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		yamba = (YambaApplication) this.getApplication();
		receiver = new TimelineReceiver();
		filter = new IntentFilter(UpdaterService.NEW_STATUS_INTENT);
		setContentView(R.layout.timeline);
		
		// Check if preferences have been set
		
		if (yamba.getPrefs().getString("username", null) == null) { //
			startActivity(new Intent(this, PrefsActivity.class)); //
			Toast.makeText(this, R.string.msgSetupPrefs, Toast.LENGTH_LONG).show();
		}
		
		// Find your views
		listTimeline = (ListView) findViewById(R.id.listTimeline);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.setupList();
		registerReceiver(receiver, filter);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(receiver);
	}
	
	private void setupList(){
		StatusData statusData = yamba.getStatusData();
		cursor = statusData.getStatusUpdates();
		startManagingCursor(cursor);
		adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, FROM, TO);
		adapter.setViewBinder(VIEW_BINDER);
		listTimeline.setAdapter(adapter);
	}
	
	static final ViewBinder VIEW_BINDER = new ViewBinder() {

		@Override
		public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
			if (view.getId() != R.id.textCreatedAt)
				return false;
			
			//Update the created at text to relative time
			long timestamp = cursor.getLong(columnIndex);
			CharSequence relTime = DateUtils.getRelativeTimeSpanString(timestamp);
			((TextView) view).setText(relTime);
			return true;
		}

	};
	
	class TimelineReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			cursor = yamba.getStatusData().getStatusUpdates();
			adapter.changeCursor(cursor);
			adapter.notifyDataSetChanged();
			Log.d("TimelineReceiver", "onReceived");
		}
		
	}

}
