package com.andy.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity {
	private ProgressBar hbar = null;
	private ProgressBar cbar = null;
	private Button start = null;
	private int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar);
		hbar = (ProgressBar)findViewById(R.id.horizontal);
		cbar = (ProgressBar)findViewById(R.id.circle);
		start = (Button)findViewById(R.id.progressbarButton);
		
		start.setOnClickListener(new ButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.progress_bar, menu);
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
	
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(i == 0){
				hbar.setVisibility(View.VISIBLE);
				cbar.setVisibility(View.VISIBLE);
			}
			else if(i < hbar.getMax()){
				hbar.setProgress(i);
				hbar.setSecondaryProgress(i + 10);
				cbar.setProgress(i);
			}
			else{
				hbar.setVisibility(View.GONE);
				cbar.setVisibility(View.GONE);
				i = -10;
			}
			i = i + 10;
		}
		
	}
}
