package com.filesdev.demos;

import java.io.File;
import java.io.IOException;

public class FilePath {

	public static void main(String[] args) {
		
		String fileName = "newFile.txt";
		String workingDirectory = System.getProperty("user.dir"); // user working directory 	
		String absoluteFilePath = workingDirectory + File.separator + fileName; 

		System.out.println("Final filePath: " + absoluteFilePath);
		
		//-----------------------------------------------------------------------------------
		
		File file = new File(absoluteFilePath);
		
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
