package com.andy.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HandlerActivity extends Activity {
	private Button handlerstartbutton = null;
	private Button handlerendbutton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler);
		handlerstartbutton = (Button)findViewById(R.id.handlerstartbutton);
		handlerendbutton = (Button)findViewById(R.id.handlerendbutton);
		
		handlerstartbutton.setOnClickListener(new StartButtonListener());
		handlerendbutton.setOnClickListener(new EndButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.handler, menu);
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
	
	Handler handler = new Handler();
	Runnable updateThread = new Runnable(){
		@Override
		public void run(){
			System.out.println("updateThread");
			handler.postDelayed(updateThread, 3000);
		}
	};
	
	class StartButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			handler.post(updateThread);
		}
		
	}
	class EndButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			handler.removeCallbacks(updateThread);
		}
		
	}
}
