package com.andy.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FactResult extends Activity {
	private TextView tv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fact_result);
		tv = (TextView)findViewById(R.id.factresult);
		Intent intent = getIntent();
		String num1 = intent.getStringExtra("number1");
		String num2 = intent.getStringExtra("number2");
		int nu1 = Integer.valueOf(num1);
		int nu2 = Integer.valueOf(num2);
		tv.setText(nu1 + " * " + nu2 + " = " + nu1 * nu2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fact_result, menu);
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
