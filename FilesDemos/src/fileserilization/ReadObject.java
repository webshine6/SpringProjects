package fileserilization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

	public static void main(String[] args) {
		
		String filename = "D:\\address.ser";
		
		Address address = null;
		
		ReadObject readObject = new ReadObject();
		try {
			address = readObject.deserializeAddress(filename);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(address);
		
	}
	
	public Address deserializeAddress(String filename) throws ClassNotFoundException {
		
		Address address = null;
			
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			address = (Address) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return address;
		
	}
	
	
}
