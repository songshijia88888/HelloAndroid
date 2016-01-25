package com.andy.helloandroid;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ShellActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shell);
		Button allProcess = (Button) findViewById(R.id.allProcess);
		Button qihoo360tencentQQ = (Button) findViewById(R.id.qihoo360tencentQQ);
		Button inputKW = (Button)findViewById(R.id.inputKW);
		
		
		inputKW.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText et = (EditText)findViewById(R.id.psinfo);
				String pid = et.getText().toString();
				System.out.println("EditText--------->" + pid);
				if(null != pid){
					String cmd = "kill -9 " + pid;
					Runtime run = Runtime.getRuntime();
					System.out.println("cmd---------->" + cmd);
					try {
						run.exec("su");
						Process p = run.exec("su;" + cmd);// 启动另一个进程来执行命令
						
						BufferedInputStream in = new BufferedInputStream(p.getInputStream());
						BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
						String lineStr;
						int count = 100;
						while ((lineStr = inBr.readLine()) != null && count > 0) {
							count--;
							System.out.println(lineStr);// 打印输出信息
						}
						// 获得命令执行后在控制台的输出信息
						in = new BufferedInputStream(p.getErrorStream());
						BufferedReader errBr = new BufferedReader(new InputStreamReader(in));
						String errStr;
						while ((errStr = errBr.readLine()) != null) {
							System.out.println(errStr);// 打印输出信息
						}

						// 检查命令是否执行失败。
						if (p.waitFor() != 0) {
							if (p.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
								System.err.println("命令执行失败!");
						}
						inBr.close();
						in.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					System.out.println("pid is null");
				}
			}
		});

		qihoo360tencentQQ.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// windows
				// String cmd = "F:\\apache-tomcat-6.0.20.exe";
				// String cmd = "D:\\Program Files\\Microsoft
				// Office\\OFFICE11\\WINWORD.EXE F:\\test.doc";
				// String cmd = "cmd.exe /c start F:\\test.doc";
				String cmd = "ping www.baidu.com";
				cmd = "ps|grep qihoo|awk '{system(\"kill -9 \"$2\"\")}'";
				cmd = "kill -9 11117";
				// linux
				// String cmd = "./fork_wait";
				// String cmd = "ls -l";
				// String[] cmd=new String[3];
				// cmd[0]="/bin/sh";
				// cmd[1]="-c";
				// cmd[2]="ls -l ./";
				Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象

				try {
					Process p = run.exec(cmd);// 启动另一个进程来执行命令
					BufferedInputStream in = new BufferedInputStream(p.getInputStream());
					BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
					String lineStr;
					int count = 100;
					while ((lineStr = inBr.readLine()) != null && count > 0) {
						count--;
						System.out.println(lineStr);// 打印输出信息
					}
					// 获得命令执行后在控制台的输出信息

					// 检查命令是否执行失败。
					if (p.waitFor() != 0) {
						if (p.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
							System.err.println("命令执行失败!");
					}
					inBr.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		allProcess.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// windows
				// String cmd = "F:\\apache-tomcat-6.0.20.exe";
				// String cmd = "D:\\Program Files\\Microsoft
				// Office\\OFFICE11\\WINWORD.EXE F:\\test.doc";
				// String cmd = "cmd.exe /c start F:\\test.doc";
				String cmd = "ping www.baidu.com";
				cmd = "ps";
				// linux
				// String cmd = "./fork_wait";
				// String cmd = "ls -l";
				// String[] cmd=new String[3];
				// cmd[0]="/bin/sh";
				// cmd[1]="-c";
				// cmd[2]="ls -l ./";
				Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象

				try {
					Process p = run.exec(cmd);// 启动另一个进程来执行命令
					BufferedInputStream in = new BufferedInputStream(p.getInputStream());
					BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
					String lineStr;
					int count = 100;
					while ((lineStr = inBr.readLine()) != null && count > 0) {
						count--;
						System.out.println(lineStr);// 打印输出信息
					}
					// 获得命令执行后在控制台的输出信息

					// 检查命令是否执行失败。
					if (p.waitFor() != 0) {
						if (p.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
							System.err.println("命令执行失败!");
					}
					inBr.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shell, menu);
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
