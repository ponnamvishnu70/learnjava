package learnjava.practice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class HandleException {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Error> nullPointerException(Exception ex){
		Error e = new Error("NPE","NullPointerException");
		ResponseEntity r = new ResponseEntity(e,HttpStatus.EXPECTATION_FAILED);
		return r;
		
	}

	
}
