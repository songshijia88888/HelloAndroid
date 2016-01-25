package com.andy.helloandroid;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class XMLActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xml);
		Button processXMLwithSAX = (Button)findViewById(R.id.processXMLwithSAX);
		
		processXMLwithSAX.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread th = new Thread(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Download_HttpDownloader hd = new Download_HttpDownloader();
						String xml = hd.download("http://www.w3school.com.cn/example/xmle/cd_catalog.xml");
						System.out.println(xml);
						
						try{
							SAXParserFactory factory = SAXParserFactory.newInstance();
							XMLReader reader = factory.newSAXParser().getXMLReader();
							reader.setContentHandler(new XMLContentHandler());
							reader.parse(new InputSource(new StringReader(xml)));
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				};
				
				th.start();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xml, menu);
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
