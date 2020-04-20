package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  
	{
		if(req.getSession().getAttribute("user")!=null)
		{
			HttpSession session = req.getSession(true);
			session.removeAttribute("user");
			session.invalidate();
			res.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}
		else res.sendRedirect(req.getContextPath() +  "/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
	}

}
