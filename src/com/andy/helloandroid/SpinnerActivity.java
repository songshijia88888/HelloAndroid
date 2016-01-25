package com.andy.helloandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SpinnerActivity extends Activity {
	private Spinner spinner = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		spinner = (Spinner)findViewById(R.id.spinner);
		Button setspinner = (Button)findViewById(R.id.setspinner);
		
		setspinner.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				List<String> list = new ArrayList<String>();
				list.add("test1");
				list.add("test2");
				list.add("17");
				list.add("26");
				list.add("sally");
				list.add("andy");
				ArrayAdapter adapter2 = new ArrayAdapter(SpinnerActivity.this, R.layout.activity_spinner_withlistcontent, R.id.spinnertextview, list);
				spinner.setAdapter(adapter2);
				spinner.setPrompt("spinner≤‚ ‘");
				spinner.setOnItemSelectedListener(new SpinnerListener());
			}
		});

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("spinner≤‚ ‘");
		spinner.setOnItemSelectedListener(new SpinnerListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner, menu);
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

class SpinnerListener implements OnItemSelectedListener{

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		String selected = parent.getItemAtPosition(position).toString();
		System.out.println(selected);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		System.out.println("nothing selected");
	}
	
}
