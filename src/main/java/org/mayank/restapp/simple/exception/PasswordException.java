/**
 * 
 */
package org.mayank.restapp.simple.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mayank
 *
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid Password!")
public class PasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordException(String message) {
		super(message);
	}	
	
}
