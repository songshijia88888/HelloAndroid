package com.andy.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

public class ListViewActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		map1.put("user_name", "zhangsan");
		map1.put("user_ip", "192.168.0.1");
		map2.put("user_name", "lisi");
		map2.put("user_ip", "192.168.0.2");
		map3.put("user_name", "wangwu");
		map3.put("user_ip", "192.168.0.2");
		list.add(map1);
		list.add(map2);
		list.add(map3);

		SimpleAdapter listAdapter = new SimpleAdapter(this, list, R.layout.user,
				new String[] { "user_name", "user_ip" }, new int[] { R.id.user_name, R.id.user_ip });
		setListAdapter(listAdapter);
	}
	
	@Override
	protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		System.out.println("id-----------------" + id);
		System.out.println("position-----------" + position);
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
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
