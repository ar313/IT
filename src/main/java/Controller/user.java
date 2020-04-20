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

@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
	{
	
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession(true);
		if(UserToXml.db.GetUser(id)==null)
		{
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return;
		}
		User r1 = UserToXml.db.GetUser(id);
		res.setContentType("text/html");
		session.setAttribute("SearchUser", r1);
		res.sendRedirect(req.getContextPath() + "/user.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
}
