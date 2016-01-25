package com.andy.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class WiFiActivity extends Activity {
	private WifiManager wifiManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi);
		Button startWiFi = (Button)findViewById(R.id.startWiFi);
		Button stopWiFi = (Button)findViewById(R.id.stopWiFi);
		Button checkWiFi = (Button)findViewById(R.id.checkWiFi);
		
		startWiFi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wifiManager = (WifiManager)WiFiActivity.this.getSystemService(Context.WIFI_SERVICE);
				wifiManager.setWifiEnabled(true);
				System.out.println("wifi stat---------->" + wifiManager.getWifiState());
				Toast.makeText(WiFiActivity.this, "当前wifi网卡状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();;
			}
		});
		
		stopWiFi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wifiManager = (WifiManager)WiFiActivity.this.getSystemService(Context.WIFI_SERVICE);
				wifiManager.setWifiEnabled(false);
				System.out.println("wifi stat---------->" + wifiManager.getWifiState());
				Toast.makeText(WiFiActivity.this, "当前wifi网卡状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();;
			}
		});
		
		checkWiFi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wifiManager = (WifiManager)WiFiActivity.this.getSystemService(Context.WIFI_SERVICE);
				System.out.println("wifi stat---------->" + wifiManager.getWifiState());
				Toast.makeText(WiFiActivity.this, "当前wifi网卡状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wi_fi, menu);
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
