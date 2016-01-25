package com.andy.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity {
	private Button myButton = null;
	private TextView myTextView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		myTextView = (TextView)findViewById(R.id.myOtherTextView);
		myTextView.setText(R.string.ANDY);
		Intent intent = getIntent();
		String message = intent.getStringExtra("testIntent");
		myTextView.setText(message);
		myButton = (Button)findViewById(R.id.myOtherButton);
		myButton.setOnClickListener(new OtherActivityListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other, menu);
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
	
	class OtherActivityListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		Uri uri = Uri.parse("smsto://13540753910");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms body", "The SMS text");
		startActivity(intent);
		}
	}
}
