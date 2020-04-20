package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserToXml;

@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
	{
		HttpSession session = req.getSession(true);
		try {
			UserToXml.loadFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.setContentType("text/html");
		session.setAttribute("users", UserToXml.db);
		res.sendRedirect(req.getContextPath() + "/users.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
}
