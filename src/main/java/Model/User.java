package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
	
	private ContactInformation Contacts;
	
	@XmlElementWrapper
	public ArrayList<Skill> ProfessionalSkills = new ArrayList<Skill>();;
	
	@XmlElementWrapper
	public ArrayList<Skill> PersonalSkills = new ArrayList<Skill>();;
	
	public User(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		
		ProfessionalSkills.add(new Skill("JAVA", 50));
		ProfessionalSkills.add(new Skill("HTML", 50));
		ProfessionalSkills.add(new Skill("CSS", 50));
		ProfessionalSkills.add(new Skill("Javascript", 50));
		 
		PersonalSkills.add(new Skill("Communicative",0));
		PersonalSkills.add(new Skill("Teamwork",0));
		PersonalSkills.add(new Skill("Creativity",0));
		
		Contacts = new ContactInformation("","","","");
	}
	
	public User(){}
	
	@XmlElement
	public int getID()
	{
		return this.id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
		
	@XmlElement  
	public String getEmail() {
		return email;
	}
	
	@XmlElement  
	public String getPassword() {
		return password;
	}
	
	@XmlElement  
	public String getJob() {
		return job;
	}

	@XmlElement  
	public String getDescription() {
		return this.description;
	}
	
	@XmlElement
	public ContactInformation getContacts()
	{
		return this.Contacts;
	}
	
	public void setContacts(ContactInformation c)
	{
		this.Contacts = c;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
