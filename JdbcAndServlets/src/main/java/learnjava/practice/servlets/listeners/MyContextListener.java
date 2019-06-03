package learnjava.practice.servlets.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//If you want to do something during deployment we should override method by implementing ServletContextListener 
public class MyContextListener implements ServletContextListener {

	//Server creates object of ServletContextEvent after creating ServletCOntext
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyContextListener is Invoked after creating servletContext Interface");
		ServletContext scontext = sce.getServletContext();
		scontext.setAttribute("listenerExample", "MyContextListener");
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
