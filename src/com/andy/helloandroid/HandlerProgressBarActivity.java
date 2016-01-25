package com.andy.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerProgressBarActivity extends Activity {
	private static ProgressBar bar = null;
	private static Button startButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_progress_bar);
		bar = (ProgressBar) findViewById(R.id.handlerprogressbar);
		startButton = (Button) findViewById(R.id.handlerprogressbarbutton);

		startButton.setOnClickListener(new ButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.handler_progress_bar, menu);
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

	private static Handler updateBarHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			bar.setProgress(msg.arg1);
			if(msg.arg1 < 100){
				updateBarHandler.post(updateThread);
			}
		};

	};

	private static Runnable updateThread = new Runnable() {
		int i = 0;

		@Override
		public void run() {
			System.out.println("ThreadBegin");
			i = i + 10;
			Message msg = updateBarHandler.obtainMessage();
			msg.arg1 = i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateBarHandler.sendMessage(msg);
			/*if (i == 100) {
				updateBarHandler.removeCallbacks(updateThread);
			}*/
		}
	};

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bar.setVisibility(View.VISIBLE);
			updateBarHandler.post(updateThread);
		}

	}
}
