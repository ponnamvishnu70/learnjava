package learnjava.practice.springcore;

import java.applet.AppletContext;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import leaarnjava.practice.springcore.model.Student;

//ApplicationContext is a child-interface of BeanFactory
//ApplicationContext is superset of BeanFactory
//ApplicationContext = BeanFactory + more enterprise-specific functionality
//ApplicationContext interface represents the Spring IoC container and is 
//responsible for instantiating, configuring, and assembling the beans.
//In stand-alone applications, it is common to create an instance of
//ClassPathXmlApplicationContext or FileSystemXmlApplicationContext
public class DependencyInjectionExample {
	public static void main(String[] args) {
		
		/*BeanFactory bf = new ClassPathXmlApplicationContext("Beans.xml");
		Student s = (Student) bf.getBean("student");
		System.out.println(s.getName());
		*/
		
		ApplicationContext appcontext = new ClassPathXmlApplicationContext("Beans.xml");
		//you can pass any number of xml files to ClassPathXmlApplicationContext class
		Student stu = (Student) appcontext.getBean("studentObjByProperties");
		System.out.println(stu.getName());
		Student stuByConstructor = (Student) appcontext.getBean("studentObjByConstructor");
		System.out.println(stuByConstructor.getName());
		//need to close as this using resource to read Beans.xml file
		((ClassPathXmlApplicationContext)appcontext).close();
		
		
		
	}

}
