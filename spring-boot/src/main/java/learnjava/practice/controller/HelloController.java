package learnjava.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public List<String> hello() {
		System.out.println("From Contoller");
		List<String> str = new ArrayList<String>();
		str.add("vishnu");
		str.add("ponnam");
		return str;
	}

}