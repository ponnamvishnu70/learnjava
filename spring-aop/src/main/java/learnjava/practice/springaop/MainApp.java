package learnjava.practice.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learnjava.practice.springaop.service.CarService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringBeans.xml");
		CarService cs = ctx.getBean(CarService.class);
		cs.getMake();
		cs.oilchange();
		//cs.brakefuildchange();
			
	}
}
