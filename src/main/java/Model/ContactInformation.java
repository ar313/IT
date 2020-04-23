package Model;

import javax.xml.bind.annotation.XmlElement;

public class ContactInformation {

	private String email;
	private String number;
	private String city;
	private String address;
	
	public ContactInformation()
	{
		
	}
	
	public ContactInformation(String email, String number, String city, String address)
	{
		this.email = email;
		this.number = number;
		this.city = city;
		this.address = address;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
	
	@XmlElement
	public String getNumber() {
		return number;
	}
	
	@XmlElement
	public String getCity() {
		return city;
	}
	
	@XmlElement
	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
