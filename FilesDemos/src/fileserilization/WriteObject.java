package fileserilization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {

	public static void main(String[] args) {
		
		WriteObject obj = new WriteObject();
		
		Address address = new Address();
		address.setCountry("Bulgaria");
		address.setSteet("Paisii Hilendarski 27");
		
		obj.serializeAddress(address);
		
		
	}
	
	
	public void serializeAddress(Address address) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\address.ser"))) {
			oos.writeObject(address);
			System.out.println("Done with serialize address object.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
