package learnjava.practice.springcore.eventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


//Here we are extending ApplicationListener and writing custom listener 
//So for all the MyEvent events published onApplicationEvent will be executed
//If you don't use generics then onApplicationEvent will be called for all events
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("from event listener");
	}

	

}
