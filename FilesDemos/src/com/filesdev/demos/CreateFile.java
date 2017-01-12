package com.filesdev.demos;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		
		File file = new File("D:\\test-file.txt");
		
		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
			}else {
				System.out.println("File already existed.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
