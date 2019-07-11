package learnjava.practice.springwebmvc.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String greet(Map<String, Object> model) {
		model.put("msg", "Hellooooo..............");
		System.out.println("inside controller");
	return "hello";	
	}
	

}
