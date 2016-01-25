package com.andy.helloandroid;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BroadcastActivity3 extends Activity {

	protected static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	private BroadcastReceiver3 receiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast_activity3);

		Button registerBroadcastReceiver3 = (Button) findViewById(R.id.registBroadcastRecevier3);
		Button unregisterBroadcastReceiver3 = (Button) findViewById(R.id.unregistBroadcastRecevier3);

		registerBroadcastReceiver3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				receiver = new BroadcastReceiver3();
				IntentFilter filter = new IntentFilter();
				filter.addAction(SMS_ACTION);
				BroadcastActivity3.this.registerReceiver(receiver, filter);
			}
		});

		unregisterBroadcastReceiver3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BroadcastActivity3.this.unregisterReceiver(receiver);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.broadcast_activity3, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
