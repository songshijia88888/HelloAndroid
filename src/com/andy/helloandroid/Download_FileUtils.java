package com.andy.helloandroid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class Download_FileUtils {
	private String SDPATH;
	public String getSDPATH(){
		return SDPATH;
	}
	
	public Download_FileUtils(){
		SDPATH = Environment.getExternalStorageDirectory() + "/";
	}
	
	public File createSDFile(String fileName)throws IOException{
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		
		return file;
	}
	
	public File createSDDir(String dirName){
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		
		return dir;
	}
	
	public boolean isFileExist(String fileName){
		File file = new File(SDPATH + fileName);
		return file.exists();
	}
	
	public File write2SDFromInput(String path, String fileName,InputStream input){
		File file = null;
		OutputStream output = null;
		
		try{
			createSDDir(path);
			file = createSDFile(path + "/" + fileName);
			output = new FileOutputStream(file);
			byte[] buffer = new byte[4 * 1024];
			int count = 0;
			while((count = input.read(buffer))!= -1){
				/*
				 * output.write(buffer)方法会造成下载的文件大小异常，
				 * 因为不是每次都刚刚好读满4K的数据到字节数组buffer中
				 * 所以要用count存储input.read(buffer)方法返回的实际读取字节数，然后使用output.write(
				 * buffer, 0, count) 方法来向文件写入刚刚好count个字节的数据
				 */
				output.write(buffer, 0, count);
			}
			output.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				output.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return file;
	}

}
