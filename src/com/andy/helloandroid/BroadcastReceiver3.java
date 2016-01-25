package com.andy.helloandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class BroadcastReceiver3 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Message is received");
		Bundle bundle = intent.getExtras();
		Object[] objs = (Object[])bundle.get("pdus");
		SmsMessage[] message = new SmsMessage[objs.length];
		System.out.println(message.length);
		for(int i = 0; i < objs.length; i++){
			message[i] = SmsMessage.createFromPdu((byte[])objs[i]);
			System.out.println(message[i].getDisplayMessageBody());
		}
	}

}
