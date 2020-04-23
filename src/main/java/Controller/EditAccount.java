package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Model.UserToXml;

@WebServlet("/editAccount")
public class EditAccount extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
	{
		res.sendRedirect(req.getContextPath() +  "/login.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String description = request.getParameter("description");
		
		
		HttpSession session = request.getSession(false);
		int id = ((Model.User)session.getAttribute("user")).getID();
		try {
			UserToXml.loadFile();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		User u1 = UserToXml.db.GetUser(id);
		int index = UserToXml.db.user.lastIndexOf(u1);
		response.addDateHeader("dd", index);
		
		if(name!=null)
		{
			u1.setName(name);
		}
		
		else if(job!=null)
		{
			u1.setJob(job);
		}
		
		else if(description!=null)
		{
			u1.setDescription(description);
		}
		else
		{	
			String parameter = request.getParameterNames().nextElement();
			System.out.println(parameter);
			return;
		}
		
		
		try {
			UserToXml.db.user.set(index, u1);
			UserToXml.saveFile();
			UserToXml.loadFile();
			session.setAttribute("user", u1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
