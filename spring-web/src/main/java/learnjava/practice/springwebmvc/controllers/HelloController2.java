package learnjava.practice.springwebmvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import learnjava.practice.springweb.exceptionhandlers.CustomException;

@ControllerAdvice
@EnableWebMvc //equivalent of <mvc:annotation-driven/> -- without this annotation @controllerAdvice will not Work
public class HelloController2 {
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("error","Something gone wrong");
		return mv;
				
	}
	

}
