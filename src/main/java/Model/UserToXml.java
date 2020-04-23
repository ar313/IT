package Model;

import java.io.File;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Controller.EditAccount;
import Controller.Login;

public class UserToXml {

	public static UserDB db;
	
	public static void addUserToXml(User user) throws Exception
	{
		int id;
		if(db.getUsers().isEmpty())
		{
			id = 0;
		} else
		{
			id = (db.getUsers().get((db.getUsers().size()-1)).getID());
		}
		
		user.setID(id+1);
		db.addUser(user);
		
		try 
		{
			saveFile();
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void saveFile() throws Exception
	{
		File file = new File(new File(Login.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() + "\\users.xml");
		JAXBContext context= JAXBContext.newInstance(UserDB.class);
		
		try 
		{
			Marshaller marshaller= context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(db, file);
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void loadFile() throws Exception
	{
		File file = new File(new File(Login.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() + "\\users.xml");
		JAXBContext context= JAXBContext.newInstance(UserDB.class);
		
		db = new UserDB();
		 
		try 
		{
			if(file.exists()) 
			{
				Unmarshaller unmarshaller = context.createUnmarshaller();
				db = (UserDB)unmarshaller.unmarshal(file);
			} 
			else
			{
				saveFile();
			}
		}
		
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
	}	
}
