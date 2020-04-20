package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String password;
	private int id;
	
	private String job = "Student";
	private String description = "Sample Description";
	
	private ArrayList<Skill> Professional;
	private ArrayList<Skill> Personal;
	
	public User(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User(){}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement  
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement  
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement  
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@XmlElement  
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}

}
