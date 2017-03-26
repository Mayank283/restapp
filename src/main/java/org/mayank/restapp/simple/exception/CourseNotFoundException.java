package org.mayank.restapp.simple.exception;

/**http://www.jcombat.com/spring/exception-handling-in-spring-restful-web-service*/
/**https://dzone.com/articles/exception-handling-spring-rest*/
/**Exception Handling in Spring:
1) ResponseEntity (send error along with http status)
2) @ResponseStatus (to be user over custom Exception class which extends exception)
3) @ExceptionHandler and @ResponseStatus (this is used on a custom Exception method at the Controller Method)
4) @ControllerAdvice (to be used when error response for global error other than our own controller are to be thrown)*/

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Course does not exist")
public class CourseNotFoundException extends Exception {
	
	private static final long serialVersionUID = -327425410446489080L;

	public CourseNotFoundException(String message) {
		super(message);
	}
}