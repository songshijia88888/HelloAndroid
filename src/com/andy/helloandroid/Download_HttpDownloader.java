package com.andy.helloandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Download_HttpDownloader {
	private URL url = null;

	public String download(String urlstr) {
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader br = null;
		
		System.out.println("开始下载");

		try {
			url = new URL(urlstr);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				sb.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("文本已下载");
		return sb.toString();
	}

	public int downFile(String urlStr, String path, String fileName) {
		InputStream inputStream = null;
		System.out.println("开始下载");
		try {
			Download_FileUtils fileUtils = new Download_FileUtils();
			if (fileUtils.isFileExist(path + "/" + fileName)) {
				System.out.println("文件已存在");
				return 1;
			} else {
				inputStream = getInputStreamFromUrl(urlStr);
				File resultFile = fileUtils.write2SDFromInput(path, fileName, inputStream);
				if (resultFile == null) {
					return -1;
				}
			}
		} catch (Exception e) {
			System.out.println("异常");
			e.printStackTrace();
			return -1;
		} finally {
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件已下载");
		return 0;
	}

	public InputStream getInputStreamFromUrl(String urlStr) throws MalformedURLException, IOException {
		url = new URL(urlStr);
		System.out.println("URL对象已生成");
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setRequestProperty("Accept-Encoding","identity");
		System.out.println("HttpURLConnection对象已打开");
		InputStream inputStream = urlConn.getInputStream();
		System.out.println("已获取输入流");
		return inputStream;
	}

}
