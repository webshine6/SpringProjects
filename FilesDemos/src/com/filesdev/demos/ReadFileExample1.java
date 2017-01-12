package com.filesdev.demos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample1 {

	private static final String FILENAME = System.getProperty("user.dir")+ File.separator + "newFile.txt";
	
	
	public static void main(String[] args) {
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
			
		try {
			fileReader = new FileReader(FILENAME);
			bufferedReader = new BufferedReader(fileReader);
			
			String currentLine = "";
			
			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);
			}
				
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
		

	}

}
