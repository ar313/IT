package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Model.UserToXml;

@WebServlet("/login")
public class Login extends HttpServlet  {

private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
	{
		res.sendRedirect(req.getContextPath() +  "/login.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			UserToXml.loadFile();
		} catch(Exception e) {}
		if(UserToXml.db.Login(email, password)==null)
		{
			response.sendRedirect(request.getContextPath() +  "/login.jsp");
			return;
		}

		User current = UserToXml.db.Login(email, password);
		
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		session.setAttribute("user", current);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
}
