package pers.wdcy.resut.reactor.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import pers.wdcy.resut.reactor.result.Result;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
//	public <T> Mono<Result<T>> handleException(Exception e) {
//		log.error(e.getMessage(), e);
//		return Mono.just(Result.error(e.getMessage(), null));
//	}
	
	@ExceptionHandler(ResponseStatusException.class)
	@ResponseStatus(code =  HttpStatus.NOT_FOUND)
	public <T> Mono<Result<T>> handleException(ResponseStatusException e) {
		log.error(e.getMessage(), e);
		return Mono.just(Result.error("接口不存在", null));
	}

}
