package fileserilization;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String country;
	private String steet;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSteet() {
		return steet;
	}
	public void setSteet(String steet) {
		this.steet = steet;
	}
	
	
	@Override
	public String toString() {
		// slower but thread safe
		return new StringBuffer()
				.append("Country: " + getCountry())
				.append(" , street: " + getSteet())
				.toString();
	}
	
	
	
	
}
