package com.andy.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioCheckActivity extends Activity {
	private RadioGroup rg = null;
	private RadioButton male = null;
	private RadioButton female = null;
	private CheckBox	ch1 = null;
	private CheckBox	ch2 = null;
	private CheckBox	ch3 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_check);
		rg = (RadioGroup)findViewById(R.id.radiogroup);
		male = (RadioButton)findViewById(R.id.male);
		female = (RadioButton)findViewById(R.id.female);
		ch1 = (CheckBox)findViewById(R.id.ch1);
		ch2 = (CheckBox)findViewById(R.id.ch2);
		ch3 = (CheckBox)findViewById(R.id.ch3);
		
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(male.getId() == checkedId){
					System.out.println("male");
					Toast.makeText(RadioCheckActivity.this, "male", Toast.LENGTH_SHORT).show();
				}
				if(female.getId() == checkedId){
					System.out.println("female");
					Toast.makeText(RadioCheckActivity.this, "female", Toast.LENGTH_SHORT).show();
				}
			}
			
		});
		ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					System.out.println("ch1 is checked");
					Toast.makeText(RadioCheckActivity.this, "ch1 is checked", Toast.LENGTH_LONG).show();
				}
				else{
					System.out.println("ch1 is unchecked");
					Toast.makeText(RadioCheckActivity.this, "ch1 is unchecked", Toast.LENGTH_LONG).show();
				}
			}
			
		});
		ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					System.out.println("ch2 is checked");
					Toast.makeText(RadioCheckActivity.this, "ch2 is checked", Toast.LENGTH_LONG).show();
				}
				else{
					System.out.println("ch1 is unchecked");
					Toast.makeText(RadioCheckActivity.this, "ch2 is unchecked", Toast.LENGTH_LONG).show();
				}
			}
			
		});
		ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					System.out.println("ch3 is checked");
					Toast.makeText(RadioCheckActivity.this, "ch3 is checked", Toast.LENGTH_LONG).show();
				}
				else{
					System.out.println("ch3 is unchecked");
					Toast.makeText(RadioCheckActivity.this, "ch3 is unchecked", Toast.LENGTH_LONG).show();
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.radio_check, menu);
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
