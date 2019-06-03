package learnjava.practice.servlets.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest().getAttributeNames());
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(sre.getServletRequest().getAttributeNames());
	}

}
