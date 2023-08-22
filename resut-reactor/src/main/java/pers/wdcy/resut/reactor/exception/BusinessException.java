package pers.wdcy.resut.reactor.exception;

import lombok.Getter;
import pers.wdcy.resut.reactor.result.Results;

@Getter
public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2050311996447888081L;

	private final Results results;
	
	public BusinessException(Results results) {
		super(results.message());
		this.results = results;
	}
	
}
