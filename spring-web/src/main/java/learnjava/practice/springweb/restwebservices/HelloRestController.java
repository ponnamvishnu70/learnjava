package learnjava.practice.springweb.restwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learnjava.practice.springweb.model.Person;

@RestController
public class HelloRestController {
	@RequestMapping("/hello")
	public Person helloRest() {
		return new Person("vishnu", "Ponnam", 16);
	}
}
