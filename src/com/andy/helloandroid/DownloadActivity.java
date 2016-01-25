package com.andy.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DownloadActivity extends Activity {
	private TextView tv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		Button downloadtext = (Button) findViewById(R.id.downloadtext);
		Button downloadmp3 = (Button) findViewById(R.id.downloadmp3);
		tv = (TextView) findViewById(R.id.downloadtextview);

		downloadtext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread th = new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Download_HttpDownloader httpDownloader = new Download_HttpDownloader();
						httpDownloader.download("http://www.cnblogs.com/songshijia88888/p/4890763.html");
					}
				};
				
				th.start();
				tv.setText("文本:http://www.cnblogs.com/songshijia88888/p/4890763.html已下载");
			}

		});

		downloadmp3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread th = new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Download_HttpDownloader httpDownloader = new Download_HttpDownloader();
						httpDownloader.downFile("http://m1.music.126.net/1ocY5EoLHs83OZ7Opo_xTA==/1296324209150763.mp3",
								"voa", "英雄的黎明.mp3");
					}
				};
				
				th.start();
				tv.setText("文件：http://m1.music.126.net/1ocY5EoLHs83OZ7Opo_xTA==/1296324209150763.mp3已下载");
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.download, menu);
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
