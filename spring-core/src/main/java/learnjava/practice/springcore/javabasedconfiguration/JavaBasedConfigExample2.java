package learnjava.practice.springcore.javabasedconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedConfigExample2 {

	@Bean(name="person3")//This id  qualifier
	public Person person2() {
		return new Person("vishnu ponnam",29);
	}
}
