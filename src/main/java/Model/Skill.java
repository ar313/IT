package Model;

import javax.xml.bind.annotation.XmlElement;

public class Skill {

	private String name;
	private float rating;
	
	public Skill()
	{
		
	}
	
	public Skill(String name, float rating)
	{
		this.name = name;
		
		if(rating >100 || rating <0)
		{
			this.rating = 0;
		}
		else
		{
			this.rating = rating;
		}
		
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public float getRating() {
		return this.rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
}
