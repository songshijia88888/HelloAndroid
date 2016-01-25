package com.andy.helloandroid;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SQLiteActivity extends Activity {
	private Button createdb = null;
	private Button updatedb = null;
	private Button insert = null;
	private Button update = null;
	private Button query = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		
		createdb = (Button)findViewById(R.id.createdb);
		updatedb = (Button)findViewById(R.id.updatedb);
		insert = (Button)findViewById(R.id.insert);
		update = (Button)findViewById(R.id.update);
		query = (Button)findViewById(R.id.query);
		
		createdb.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteOpenHelper2 dbhelper = new SQLiteOpenHelper2(SQLiteActivity.this, "test_andy_db");
				dbhelper.getReadableDatabase();
			}
		
		});
		updatedb.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteOpenHelper2 dbhelper = new SQLiteOpenHelper2(SQLiteActivity.this, "test_andy_db", 2);
				dbhelper.getReadableDatabase();

			}
		
		});
		insert.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteOpenHelper2 dbhelper = new SQLiteOpenHelper2(SQLiteActivity.this, "test_andy_db", 2);
				SQLiteDatabase db = dbhelper.getReadableDatabase();
				ContentValues values = new ContentValues();
				values.put("id", 17);
				values.put("name", "sally");
				db.insert("user", null, values);
				values.put("id", 26);
				values.put("name", "andy");
				db.insert("user", null, values);
			}
		
		});
		update.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues values = new ContentValues();
				values.put("name", "sally2");
				SQLiteOpenHelper2 dbhelper = new SQLiteOpenHelper2(SQLiteActivity.this, "test_andy_db", 2);
				SQLiteDatabase db = dbhelper.getReadableDatabase();
				db.update("user", values, "id=?", new String[]{"1"});
			}
		
		});
		query.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SQLiteOpenHelper2 dbhelper = new SQLiteOpenHelper2(SQLiteActivity.this, "test_andy_db", 2);
				SQLiteDatabase db = dbhelper.getReadableDatabase();
				Cursor cursor = db.query("user", new String[]{"id","name"}, "id=?", new String[]{"1"}, "", "", "");
				while(cursor.moveToNext()){
					String name = cursor.getString(cursor.getColumnIndex("name"));
					System.out.println("query-->" + name);
				}
			}
		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sqlite, menu);
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
