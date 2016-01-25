package com.andy.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button myButton = null;
	private Button toFact = null;
	private TextView myTextView = null;
	private Button radiocheckbox = null;
	private Button progressbar = null;
	private Button listview = null;
	private Button handler = null;
	private Button handlerprogressbar = null;
	private Button tosqlite = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myTextView = (TextView) findViewById(R.id.myTextView);
		myButton = (Button) findViewById(R.id.myButton);
		toFact = (Button) findViewById(R.id.toFact);
		radiocheckbox = (Button) findViewById(R.id.radiocheckbox);
		progressbar = (Button) findViewById(R.id.progressbar);
		listview = (Button)findViewById(R.id.listview);
		handler = (Button)findViewById(R.id.handler);
		handlerprogressbar = (Button)findViewById(R.id.handlerprogressbar);
		tosqlite = (Button)findViewById(R.id.toSQLite);
		Button toDownload = (Button)findViewById(R.id.toDownload);
		Button toXML = (Button)findViewById(R.id.toXML);
		Button toBroadcast = (Button)findViewById(R.id.toBroadcast);
		Button toBroadcast3 = (Button)findViewById(R.id.toBroadcast3);
		Button toWiFi = (Button)findViewById(R.id.toWiFi);
		Button toSocket = (Button)findViewById(R.id.toSocket);
		Button toService = (Button)findViewById(R.id.toService);
		Button toSpinner = (Button)findViewById(R.id.toSpinner);
		Button toRatingBar = (Button)findViewById(R.id.toRatingBar);
		Button toSeekBar = (Button)findViewById(R.id.toSeekBar);
		Button toDatePicker = (Button)findViewById(R.id.toDatePicker);
		Button toAutoComplete = (Button)findViewById(R.id.toAutoComplete);
		Button toExpandableList = (Button)findViewById(R.id.toExpandableList);
		Button toShell = (Button)findViewById(R.id.toShell);
		
		toShell.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ShellActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toExpandableList.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ExpandableListActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toAutoComplete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, AutoCompleteActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		
		toDatePicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DatePickerDialogActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});

		toSeekBar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SeekBarActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toRatingBar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, RatingBarActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toSpinner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SpinnerActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toService.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ServiceActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toSocket.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SocketActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toWiFi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, WiFiActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toBroadcast3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, BroadcastActivity3.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toBroadcast.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, BroadcastActivity2.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		toXML.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, XMLActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		toDownload.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, DownloadActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		tosqlite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SQLiteActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		myTextView.setText("我的第一个TextView");
		myButton.setText("我的第一个Button" + "\n" + "test");
		myButton.setOnClickListener(new MyButtonListener());
		toFact.setOnClickListener(new MyButtonListener2());
		radiocheckbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, RadioCheckActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		progressbar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ProgressBarActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		listview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ListViewActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		handler.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, HandlerActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		
		handlerprogressbar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, HandlerProgressBarActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	class MyButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.putExtra("testIntent", "message from MainActivity");
			intent.setClass(MainActivity.this, OtherActivity.class);
			MainActivity.this.startActivity(intent);
		}
	}

	class MyButtonListener2 implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, FactNumber.class);
			MainActivity.this.startActivity(intent);
		}
	}
}
