package com.filesdev.demos;

import java.io.File;
import java.io.IOException;

public class FilePermission {

	public static void main(String[] args) {
		
		File file1 = new File(System.getProperty("user.dir"),"newFile-2.txt");
		
		if (file1.exists()) {
			System.out.println("Is Execute allow: " + file1.canExecute());
			System.out.println("Is Write allow: "+file1.canWrite());
			System.out.println("Is Read allow:  " + file1.canRead());
		}
		
		System.out.println("-----------------------------------------------");
		
		file1.setWritable(false);
		System.out.println("Is Writable allowed:  " + file1.canWrite());
		

		try {
			if (file1.createNewFile()) {
				System.out.println("File is created.");
			}else {
				System.out.println("File already existed.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
