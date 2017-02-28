package com.mama.yamba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StatusActivity extends Activity implements OnClickListener, TextWatcher {
	private static final String TAG = "StatusActivity";
	private static final Integer MAX_LEN = 140;
	EditText editText;
	Button buttonUpdate;
	TextView counterText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);

		editText = (EditText) findViewById(R.id.editText);
		editText.addTextChangedListener(this);
		
		buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
		buttonUpdate.setOnClickListener(this);
		
		counterText = (TextView) findViewById(R.id.counterText);
		counterText.setText(Integer.toString(MAX_LEN));
		counterText.setTextColor(Color.GREEN);
		

	}

	class PostToTwitter extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... arg0) {
			try {
				Log.d(TAG, "BACKGROUND!");
				return "FOI!";
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				return "TAKIPA";
			}
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG)
					.show();
		}
	}

	@Override
	public void onClick(View arg0) {
		String status = editText.getText().toString();
		new PostToTwitter().execute(status);
		Log.d(TAG, "onClick");
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		Integer len = MAX_LEN - editText.getText().length();
		counterText.setText(len.toString());
		if(len >= 30)
			counterText.setTextColor(Color.GREEN);
		else if(len < 30 && len >= 10)
			counterText.setTextColor(Color.YELLOW);
		else if(len < 10)
			counterText.setTextColor(Color.RED);
		
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		
		
	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemPrefs:
			startActivity(new Intent(this, PrefsActivity.class));
			break;
		}
		return true;
	}
}