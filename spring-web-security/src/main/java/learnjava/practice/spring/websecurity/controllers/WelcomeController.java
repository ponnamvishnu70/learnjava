package learnjava.practice.spring.websecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	  @RequestMapping(value="/hello")
	    public String sayHelloAgain(ModelMap model) {
	        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
	        return "hello";
	    }
	
}
