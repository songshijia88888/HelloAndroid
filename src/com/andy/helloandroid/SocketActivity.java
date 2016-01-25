package com.andy.helloandroid;

import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SocketActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket);
		Button startTCPserver = (Button) findViewById(R.id.startTCPServer);
		Button startUDPserver = (Button) findViewById(R.id.startUDPServer);

		startTCPserver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread tcpthread = new Thread(new TCPThread());
				tcpthread.start();
			}
		});

		startUDPserver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Thread udpthread = new Thread(new UDPThread());
				udpthread.start();
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket, menu);
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
	
	class TCPThread implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(4567);
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				byte[] buffer = new byte[4 * 1024];
				int temp = 0;
				while ((temp = inputStream.read(buffer)) != -1) {
					System.out.println(new String(buffer, 0, temp));
				}
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					serverSocket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	class UDPThread implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				DatagramSocket socket = new DatagramSocket(4567);
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				String reslut = new String(packet.getData(), packet.getOffset(), packet.getLength());
				System.out.println("reslut----------->" + reslut);
				socket.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
