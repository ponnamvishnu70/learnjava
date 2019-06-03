package learnjava.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifyUserServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		PrintWriter pw = resp.getWriter();
		String fname = "";
		String lname = "";
		if(session != null) {
			fname = (String)session.getAttribute("fname");
			lname = (String)session.getAttribute("lname");
		}
		pw.println("from ModifyUserServlet"+fname +" "+lname);
	}

}
