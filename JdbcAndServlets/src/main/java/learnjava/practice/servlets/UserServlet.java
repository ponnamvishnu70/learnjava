package learnjava.practice.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import learnjava.practice.servlets.listeners.MySessionBindingListener;

public class UserServlet extends HttpServlet {

	// We can have service method to respond to any type of request (get post put
	// ........)
	/*
	 * @Override protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { String fname
	 * =req.getParameter("fname"); String lname =req.getParameter("lname");
	 * PrintWriter pw = resp.getWriter();
	 * pw.println("You full name is "+fname+" "+lname); }
	 */

	// Service method internally check for method type from request and then call
	// the corresponding method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		PrintWriter pw = resp.getWriter();
		pw.println("You full from get method name is " + fname + " " + lname);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		System.out.println("session created printing from user servlet");
		session.setAttribute("fname", fname);
		session.setAttribute("lname", lname);
		MySessionBindingListener msbl = new MySessionBindingListener();
		session.setAttribute("MySessionBindingListener", msbl);
		Cookie c = new Cookie("ServletPraticeApp", "JdbcAndServlet");
		resp.addCookie(c);
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cook : cookies) {
				if (cook.getName().equals("ServletPraticeApp")) {
					System.out.println("received cookie back in request");
				}
			}
		}

		// One for Application....context param comes from web.xml
		ServletContext scont = req.getServletContext();
		// Other way of getting servlet context
		getServletContext();
		System.out.println(scont.getInitParameter("TV"));
		// One for Servlet...init param comes from web.xml
		ServletConfig sconf = getServletConfig();
		System.out.println(sconf.getInitParameter("TV"));
		session.invalidate();
		System.out.println("listenerExample " + scont.getAttribute("listenerExample"));
		pw.println("You full name from post method is " + fname + " " + lname);
		System.out.println("You full name from post method is " + fname + " " + lname);
		// Forwarding request to different servlet or html or jsp
		// RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		RequestDispatcher rd = req.getRequestDispatcher("modify");
		rd.forward(req, resp);
	}

}
