package learnjava.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet2 extends HttpServlet {
	//UserServlet2 called ModifyUserServlet by invoking requestdispatcher.include
	//UserServlet2 will respond back to browser by including response of ModifyUserServlet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		PrintWriter pw = resp.getWriter();
		System.out.println("You full name from post method is " + fname + " " + lname);
		RequestDispatcher rd = req.getRequestDispatcher("modify");
		rd.include(req, resp);
		pw.println("You full name from post method is " + fname + " " + lname);
	}

}
