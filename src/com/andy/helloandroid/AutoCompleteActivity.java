package com.andy.helloandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class AutoCompleteActivity extends Activity {
	private AutoCompleteTextView auto = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_complete);
		auto = (AutoCompleteTextView) findViewById(R.id.autoComplete);
		Button setAutonContent = (Button) findViewById(R.id.setAutonContent);

		setAutonContent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String[] autoContent = new String[] { "China", "Japan", "England", "America", "Canada", "France", "", "", "",
						"Rusia", "Google", "Microsoft", "Oracle", "Amazon", "India"};
				ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AutoCompleteActivity.this, R.layout.activity_auto_complete_list_item,
						autoContent);
				auto.setAdapter(arrayAdapter);
			}
		});

		List<String> list = new ArrayList<String>();
		list.add("sally");
		list.add("andy");
		list.add("17");
		list.add("26");
		list.add("9527");
		list.add("hello world");
		list.add("hello android");
		list.add("hello java");

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_auto_complete_list_item,
				list);
		auto.setAdapter(arrayAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.auto_complete, menu);
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
