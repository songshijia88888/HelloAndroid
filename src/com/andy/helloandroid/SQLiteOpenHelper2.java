package com.andy.helloandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteOpenHelper2 extends SQLiteOpenHelper {
	private static final int VERSION = 1;
	
	public SQLiteOpenHelper2(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public SQLiteOpenHelper2(Context context, String name, int version){
		this(context, name, null, version);
	}
	
	public SQLiteOpenHelper2(Context context, String name){
		this(context, name, VERSION);
	}
	
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("create a DataBase");
		db.execSQL("create table user(id int, name varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("update a DataBase");
	}

}
