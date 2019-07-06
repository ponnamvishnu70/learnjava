package learnjava.practice.springcore.eventlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;



public class MyEvent extends ApplicationEvent {

	public MyEvent(Object source) {
		super(source);
		this.doSomething();
	}
	
	public void doSomething() {
		System.out.println("printing from MyEvent class");
		
	}

}
