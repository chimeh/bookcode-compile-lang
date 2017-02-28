package com.marakana.yamba;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
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

public class StatusActivity extends BaseActivity implements OnClickListener,
		TextWatcher{

	private static final String TAG = "StatusActivity";

	EditText editText;
	Button updateButton;
	TextView textCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);
		// aggiungo le altre view, ovvero il field x editare il testo e il
		// bottone
		// di update

		editText = (EditText) findViewById(R.id.editText);
		updateButton = (Button) findViewById(R.id.buttonUpdate);
		updateButton.setOnClickListener(this);

		textCount = (TextView) findViewById(R.id.textCount);
		textCount.setText(Integer.toString(140));
		textCount.setTextColor(Color.GREEN);
		editText.addTextChangedListener(this);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	class PostToTwitter extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... statuses) {
			try {
				Twitter.Status status = ((YambaApplication)getApplication()).getTwitter().updateStatus(statuses[0]);
				return status.text;
			} catch (TwitterException e) {
				Log.e(TAG, e.toString());
				e.printStackTrace();
				return "Failed to post";
			}
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG)
					.show();
		}

	}

	@Override
	public void onClick(View v) {
		Log.d(TAG, "onClick method");
		String status = this.editText.getText().toString();
		new PostToTwitter().execute(status);

	}

	@Override
	public void afterTextChanged(Editable statusText) {
		int count = 140 - statusText.length();
		textCount.setText(Integer.toString(count));
		textCount.setTextColor(Color.GREEN);
		if (count < 15)
			textCount.setTextColor(Color.YELLOW);
		if (count < 0)
			textCount.setTextColor(Color.RED);

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

}
