package learnjava.practice.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello!!";
	}
	
	@GetMapping("/dev")
	public String dev() {
		return "Hello! developer!!!!!";
	}
	@GetMapping("/admin")
	public String admin() {
		return "Hello! admin!!!!!";
	}
	
}
