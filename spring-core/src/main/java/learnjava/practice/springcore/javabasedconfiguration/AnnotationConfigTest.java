package learnjava.practice.springcore.javabasedconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigTest {
	
	
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext is for checking annotation based configuration
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaBasedConfigExample.class);
		Person p = ctx.getBean("person2",Person.class);
		System.out.println(p.getName());
		((AnnotationConfigApplicationContext)ctx).close();
		//-----------OR------------------------
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
		ctx2.register(JavaBasedConfigExample.class);
		ctx2.refresh();
		Person p2 = ctx2.getBean(Person.class);
		System.out.println(p2.getName());
		((AnnotationConfigApplicationContext)ctx2).close();
		//----------OR-------------------------
		AnnotationConfigApplicationContext ctx3 = new AnnotationConfigApplicationContext();
		ctx3.register(JavaBasedConfigExample.class);
		ctx3.refresh();
		Person p3 = ctx3.getBean("person3",Person.class);
		System.out.println(p3.getName());
		((AnnotationConfigApplicationContext)ctx3).close();
	}

}
