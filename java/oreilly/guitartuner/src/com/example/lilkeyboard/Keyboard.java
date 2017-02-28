package com.example.lilkeyboard;

import java.io.File;
import java.io.IOException;

import org.puredata.android.io.AudioParameters;
import org.puredata.android.io.PdAudio;
import org.puredata.android.utils.PdUiDispatcher;
import org.puredata.core.PdBase;
import org.puredata.core.utils.IoUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Keyboard extends Activity implements OnClickListener{
	
	private static final String TAG = "Keyboard";
	private PdUiDispatcher dispatcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initGui();
		
		try{
			initPd();
			loadPatch();
		} catch(IOException e){
			Log.e(TAG, e.toString());
			finish();
		}
	}
	
	private void initPd() throws IOException{
		//Configure the audio glue
		int sampleRate = AudioParameters.suggestSampleRate();
		PdAudio.initAudio(sampleRate, 0, 2, 8, true);
		
		//Create and install the dispatcher
		dispatcher = new PdUiDispatcher();
		PdBase.setReceiver(dispatcher);
	}
	
	private void initGui(){
		setContentView(R.layout.activity_keyboard);
		Button eButton = (Button)findViewById(R.id.e_button);
		eButton.setOnClickListener(this);
		Button aButton = (Button)findViewById(R.id.a_button);
		aButton.setOnClickListener(this);
		Button dButton = (Button)findViewById(R.id.d_button);
		dButton.setOnClickListener(this);
		Button gButton = (Button)findViewById(R.id.g_button);
		gButton.setOnClickListener(this);
		Button bButton = (Button)findViewById(R.id.b_button);
		bButton.setOnClickListener(this);
		Button eeButton = (Button)findViewById(R.id.ee_button);
		eeButton.setOnClickListener(this);
		
	}
	
	private void loadPatch() throws IOException{
		File dir = getFilesDir();
		IoUtils.extractZipResource(
				getResources().openRawResource(R.raw.keyboard), dir, true);
		File patchFile = new File(dir, "keyboard.pd");
		PdBase.openPatch(patchFile.getAbsolutePath());		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.keyboard, menu);
		return true;
	}

	@Override
	protected void onResume(){
		super.onResume();
		PdAudio.startAudio(this);		
	}

	@Override
	protected void onPause(){
		super.onPause();
		PdAudio.stopAudio();
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		PdAudio.release();
		PdBase.release();
	}
	
	private void triggerNote(int n){
		PdBase.sendFloat("midinote", n);
		PdBase.sendBang("trigger");
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.e_button:
			triggerNote(52);
			break;

		case R.id.a_button:
			triggerNote(57);
			break;

		case R.id.d_button:
			triggerNote(62);
			break;

		case R.id.g_button:
			triggerNote(67);
			break;

		case R.id.b_button:
			triggerNote(71);
			break;

		case R.id.ee_button:
			triggerNote(76);
			break;
			
		}
	}

}
