package learnjava.practice.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learnjava.practice.springcore.model.Car;
import learnjava.practice.springcore.model.Person;
import learnjava.practice.springcore.model.Student;

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
		Person person = (Person) appcontext.getBean("person");
		System.out.println(person.getStudent().getName());
		Student stuen = (Student) appcontext.getBean("enrolledStudent");
		stuen.getSubjects().forEach(s->{System.out.println(s);});
		//autowire By Name
		Person personbyName = (Person) appcontext.getBean("personAutoWireByName");
		System.out.println(personbyName.getStudent().getName());
		
		Car c = appcontext.getBean("car",Car.class);
		//we will get an exception if we don't have make property value assigned during bean creation
		System.out.println(c.getMake());
		//need to close as this using resource to read Beans.xml file
		ServiceExample serviceExample = appcontext.getBean("serviceExample",ServiceExample.class);
		serviceExample.Process();
	
		
		((ClassPathXmlApplicationContext)appcontext).close();
		
		
		
	}

}
