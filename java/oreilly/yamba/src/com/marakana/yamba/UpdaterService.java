package com.marakana.yamba;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UpdaterService extends Service {

	private static final String TAG = "UpdaterService";
	public static final String NEW_STATUS_INTENT = "com.marakana.yamba.NEW_STATUS";
	public static final String NEW_STATUS_EXTRA_COUNT = "NEW_STATUS_EXTRA_COUNT";
	private static final int DELAY = 60000;
	private boolean runFlag = false;
	private Updater updater;
	private YambaApplication yamba;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		this.yamba = (YambaApplication) getApplication();
		this.updater = new Updater();
		Log.d(TAG, "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d(TAG, "onStart");
		this.runFlag = true;
		this.updater.start();
		this.yamba.setServiceRunning(true);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		this.runFlag = false;
		this.updater.interrupt();
		this.updater = null;
		this.yamba.setServiceRunning(false);
		super.onDestroy();
	}

	private class Updater extends Thread {
		
		Intent intent;

		public Updater() {
			super("UpdaterService-Updater");
		}

		@Override
		public void run() {
			UpdaterService updaterService = UpdaterService.this;
			while (updaterService.runFlag) {
				Log.d(TAG, "Running background thread");
				try {
					YambaApplication yamba = (YambaApplication) updaterService
							.getApplication();
					int newUpdates = yamba.fetchStatusUpdates();
					if(newUpdates > 0){
						Log.d(TAG, "We have a new status");
						intent = new Intent(NEW_STATUS_INTENT);
						intent.putExtra(NEW_STATUS_EXTRA_COUNT, newUpdates);
						updaterService.sendBroadcast(intent);
					}
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					updaterService.runFlag = false;
				}
			}
		}
	}

}
