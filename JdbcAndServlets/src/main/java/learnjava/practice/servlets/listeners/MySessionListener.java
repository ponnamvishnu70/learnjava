package learnjava.practice.servlets.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session is created"+se.getSession());		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	System.out.println("session destroyed"+se.getSession());
		
	}

}
