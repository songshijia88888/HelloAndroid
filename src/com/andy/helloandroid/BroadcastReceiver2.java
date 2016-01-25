package com.andy.helloandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastReceiver2 extends BroadcastReceiver{
	public BroadcastReceiver2() {
		// TODO Auto-generated constructor stub
		System.out.println("BroadcastReceiver2 created.");
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Broadcast received and processed");
	}
}
