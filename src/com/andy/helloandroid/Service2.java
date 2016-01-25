package com.andy.helloandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Service2 extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("service onBind");
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("service onCreate");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("flags---------->" + flags);
		System.out.println("startId-------->" + startId);
		System.out.println("serice onStartCommand");
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("servcie onDestory");
		super.onDestroy();
	}

}
