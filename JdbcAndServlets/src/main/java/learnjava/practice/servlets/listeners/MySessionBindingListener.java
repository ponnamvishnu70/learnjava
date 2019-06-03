package learnjava.practice.servlets.listeners;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBindingListener implements HttpSessionBindingListener{

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(event.getName());
		
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(event.getName());
	}

}
