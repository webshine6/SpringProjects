package com.filesdev.demos;

import java.io.File;
import java.io.IOException;

public class FilePath2 {

	public static void main(String[] args) {
		
		String workingDirectory=System.getProperty("user.dir");
		String fileName = "newFile-2.txt";
		
		File file = new File(workingDirectory, fileName); 

		//-----------------------------------------------------------------------------------
		
		System.out.println("Final filePath: " + file.getAbsolutePath());	
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}else {
				System.out.println("File already existed!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
