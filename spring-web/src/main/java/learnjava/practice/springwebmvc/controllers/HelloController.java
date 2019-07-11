package learnjava.practice.springwebmvc.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import learnjava.practice.springweb.exceptionhandlers.CustomException;

@Controller
public class HelloController {
	
	@RequestMapping("/hello/{name}")
	public String greet(Map<String, Object> model,@PathVariable("name") String name) {
		System.out.println(name);
		model.put("msg", "Hellooooo.............."+name);
		System.out.println("inside controller");
	return "hello";	
	}
	
	//@modelattribute to get form objecct from front end
	//EX front end from will have modelattribute as an <form:form method="post" modelAttribute="fileUploadForm">
	//Model(I) and ModelMap a class to carry data to front ends
	//modelandview container of both view name and data
	//all the method arguments will be passed by spring container
	@RequestMapping("/hello1")
	public String greet1(Map<String, Object> model,@RequestParam("name") String name, HttpServletRequest req) {
		System.out.println(req.getContextPath());
		System.out.println(model);
		System.out.println(name);		
		model.put("msg", "Hellooooo1.............."+name);
		System.out.println("inside controller");
	return "hello";	
	}
	
	
	@RequestMapping("/hello2")
	public String greet2(HttpServletRequest req) {
		if(req.getContextPath()!="vishnu") {//this code is just satisfy compiler 
		throw new CustomException("Exception from greet2");
		}
		return "hello";	
	}
	

	

}
