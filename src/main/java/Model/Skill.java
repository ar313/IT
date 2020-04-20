package Model;

public class Skill {

	private String name;
	private float rating;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getRating() {
		return this.rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
}
