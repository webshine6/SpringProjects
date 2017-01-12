package com.filesdev.demos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	private static final String FILENAME;
	
	static {
		FILENAME = System.getProperty("user.dir") + File.separator + "newFile.txt"; 
	}
	
	public static void main(String[] args) {

		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
			String content = "This is the content to write into file\n";
			
			writer.write(content);
			System.out.println("Done");
		}catch (IOException ioex) {
			ioex.printStackTrace();
		}
		

	}



}
