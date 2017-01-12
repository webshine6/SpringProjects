package com.filesdev.demos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
	
	private static final String FILENAME;
	
	static {
		FILENAME = System.getProperty("user.dir") + File.separator + "newFile.txt"; 
	}
	
	
	public static void main(String[] args) {
		
		String data = " This is new content";
		
		File file = new File(FILENAME);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write(data);
				System.out.println("Done with appending data to file - " + FILENAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
