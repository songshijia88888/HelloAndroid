package com.andy.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FactNumber extends Activity {
	private EditText et1 = null;
	private EditText et2 = null;
	private Button bt = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fact_number);
		et1 = (EditText)findViewById(R.id.num1);
		et2 = (EditText)findViewById(R.id.num2);
		bt = (Button)findViewById(R.id.factbutton);
		bt.setOnClickListener(new MyButtonListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fact_number, menu);
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
	
	class MyButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.putExtra("number1", et1.getText().toString());
			intent.putExtra("number2", et2.getText().toString());
			intent.setClass(FactNumber.this, FactResult.class);
			FactNumber.this.startActivity(intent);
		}
		
	}
}
