package Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDB {

	@XmlElementWrapper
	public ArrayList<User> user = new ArrayList<User>();  // users 
	
	public void addUser(User user1) 
	{
		user.add(user1);		// add user
	}
	
	public ArrayList<User>getUsers(){return this.user;}
	
	public boolean findUser(String username)
	{
		for(User user1: user)  
		{
			if(user1.getEmail().equals(username)){return true;}
			return false;
		}
		return false;
	}
	
	public User Login(String username, String password)
	{
		for(User user1: user)  
		{
			if(user1.getEmail().equals(username) && user1.getPassword().equals(password))
			{
				return user1;
				}
		}
		return null;
	}
	
	public User GetUser(int id)
	{
		for(User user1: user)  
		{
			if(user1.getID()==id)
			{
				return user1;
			}
		}
		return null;
	}
	
}
