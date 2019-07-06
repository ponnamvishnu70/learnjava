package learnjava.practice.springcore.javabasedconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

//we can have multiple configuration java classes.
//we can use this class to import all other configuration java file by using @import annotation.
//so that we can just pass this class to constructor of AnnotationConfigApplicationContext

@Configuration
@Import(JavaBasedConfigExample2.class)
public class JavaBasedConfigExample {

	@Bean(initMethod = "init", destroyMethod = "cleanup" )//only for this bean life cycle call back will be called. 
	//if you write @postconstruct and predestroy then the call back method will be call for all the Person Beans
	@Primary//If there are multiple beans of same type .you can make one of as primary so that spring container know what is default bean
	public Person person1() {
		return new Person("vishnuuuu",28);
	}
	@Bean(name="person2")//This id  qualifier
	@Scope("prototype")//default is singleton
	public Person person2() {
		return new Person("ponnammmmm",30);
	}
	
	//the bean id is name of the method
	@Scope("prototype")//default is singleton
	public Person person3() {
		return new Person("ponnammmmm",30);
	}
}
