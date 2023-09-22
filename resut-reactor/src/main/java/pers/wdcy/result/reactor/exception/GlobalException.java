package pers.wdcy.result.reactor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GlobalException extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 502776169978765606L;

	public GlobalException(HttpStatus status) {
		super(status);
	}
	
	public GlobalException(HttpStatus status, String message, Throwable e) {
		super(status, message, e);
	}

}
