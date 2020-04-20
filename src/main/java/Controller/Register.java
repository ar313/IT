package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Model.UserToXml;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException  
	{
		res.sendRedirect(req.getContextPath() +  "/register.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("confirm-password");
		
		HttpSession session = request.getSession(true);
		User r1 = new User(name,email,password);
		if(!Validate(email,password,cpassword))
		{
			session.setAttribute("Error", "Please Check your data");
			response.sendRedirect(request.getContextPath() + "/register.jsp");
			return;
		}
		
		try {
			UserToXml.loadFile();
			if(UserToXml.db.findUser(email))
			{
				session.setAttribute("Error", "User Already exists");
				response.sendRedirect(request.getContextPath() + "/register.jsp");
				return;
			}
			UserToXml.addUserToXml(r1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");

		session.setAttribute("user", r1);
		session.setAttribute("users", UserToXml.db);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	
	public Boolean Validate(String email, String password, String cpassword)
	{
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(!matcher.matches())
		{
			return false;
		}
		
		if(!password.equals(cpassword))
		{
			return false;
		}
		
		return true;
	}
}
