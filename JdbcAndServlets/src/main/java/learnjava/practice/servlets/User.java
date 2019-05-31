package learnjava.practice.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname =req.getParameter("fname");
		String lname =req.getParameter("fname");
		super.service(req, resp);
	}

}
