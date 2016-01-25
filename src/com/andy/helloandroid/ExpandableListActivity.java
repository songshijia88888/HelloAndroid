package com.andy.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleExpandableListAdapter;

public class ExpandableListActivity extends android.app.ExpandableListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list);
		List<Map<String, String>> group = new ArrayList<Map<String, String>>();
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("group", "sally");
		group.add(temp);
		Map<String, String> temp2 = new HashMap<String, String>();
		temp2.put("group", "andy");
		group.add(temp2);

		List<List<Map<String, String>>> groupitem = new ArrayList<List<Map<String, String>>>();
		
		
		List<Map<String, String>> item = new ArrayList<Map<String, String>>();
		Map<String, String> temp3 = new HashMap<String, String>();
		temp3.put("item", "female");
		item.add(temp3);
		Map<String, String> temp4 = new HashMap<String, String>();
		temp4.put("item", "german");
		item.add(temp4);
		Map<String, String> temp5 = new HashMap<String, String>();
		temp5.put("item", "beautiful");
		item.add(temp5);
		Map<String, String> temp6 = new HashMap<String, String>();
		temp6.put("item", "Shanghai");
		item.add(temp6);
		Map<String, String> temp7 = new HashMap<String, String>();
		temp7.put("item", "17");
		item.add(temp7);
		groupitem.add(item);

		List<Map<String, String>> item2 = new ArrayList<Map<String, String>>();
		Map<String, String> temp8 = new HashMap<String, String>();
		temp8.put("item", "male");
		item2.add(temp8);
		Map<String, String> temp9 = new HashMap<String, String>();
		temp9.put("item", "china");
		item2.add(temp9);
		Map<String, String> temp10 = new HashMap<String, String>();
		temp10.put("item", "stupid");
		item2.add(temp10);
		Map<String, String> temp11 = new HashMap<String, String>();
		temp11.put("item", "ChengDu");
		item2.add(temp11);
		Map<String, String> temp12 = new HashMap<String, String>();
		temp12.put("item", "26");
		item2.add(temp12);
		groupitem.add(item2);

		SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(this, group,
				R.layout.activity_expandable_list_group, new String[] { "group" }, new int[] { R.id.group }, groupitem,
				R.layout.activity_expandable_list_group_item, new String[] { "item" }, new int[] { R.id.groupitem });
		setListAdapter(sela);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expandable_list, menu);
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
