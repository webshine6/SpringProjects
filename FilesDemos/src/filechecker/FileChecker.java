package filechecker;

import java.io.File;
import java.io.FilenameFilter;

public class FileChecker {

	private static final String FILE_DIR = "D:\\myfolder";
	private static final String FILE_EXT = ".txt";
	
	public static void main(String[] args) {
		new FileChecker().deleteFile(FILE_DIR, FILE_EXT);
	}
	
	// delete all files in folder with "ext" extension
	public void deleteFile(String folder, String ext) {
		
		File dirFile = new File(folder);
		
		if (!dirFile.exists()) {
			System.out.println("Directory does not exists: " + FILE_DIR);
			return;
		}
			
		GenericExtFilter extFilter = new GenericExtFilter(FILE_EXT);
		
		// //list out all the file name with .txt extension
		String[] fileList = dirFile.list(extFilter);
		
		// check for exists files with .txt extension
		if (fileList.length == 0) {
			System.out.println("No files end with: " + FILE_EXT);
			return;
		}
		
		// set file to delete
		File fileToDelete;
		
		for (String file : fileList) {
			String temp = new StringBuffer(FILE_DIR)
					.append(File.separator)
					.append(file)
					.toString();  
		
			fileToDelete = new File(temp);
			
			System.out.println("File size in bytes: " + fileToDelete.length());
			System.out.println("File size in kilobytes: " + (fileToDelete.length() / 1024));
			
			
			fileToDelete.delete();
			
			System.out.println("File: " + temp + " is deleted");
		}
		
	}
	

	
	// inner class generic extension filter
	public class GenericExtFilter implements FilenameFilter {

		private String ext;
		
		public GenericExtFilter(String ext) {
			this.ext = ext;
		}
		
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
		
	}
	
	
}



