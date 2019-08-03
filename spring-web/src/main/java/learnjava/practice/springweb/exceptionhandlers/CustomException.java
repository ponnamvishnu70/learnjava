package learnjava.practice.springweb.exceptionhandlers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -5474909350218611697L;

	public CustomException(String errorMsg) {
		super(errorMsg);
	}

	

}
