package learnjava.practice.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello! Good Morning!!!";
	}
	
	
	@GetMapping("/hello/{partoftheday}")
	public String hello(@PathVariable("partoftheday") String partoftheday) {
		return "Hello! Good "+partoftheday+"!!!";
	}
	
	@GetMapping("/greetings")
	public String greeting(@RequestParam("partoftheday") String partoftheday) {
		return "REQUESTPARAMS Hello! Good "+partoftheday+"!!!";
	}
	
}
