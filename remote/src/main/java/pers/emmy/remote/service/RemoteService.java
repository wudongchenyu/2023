package pers.emmy.remote.service;

import org.springframework.http.MediaType;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import reactor.core.publisher.Mono;

@HttpExchange(accept = MediaType.APPLICATION_NDJSON_VALUE, contentType = MediaType.APPLICATION_NDJSON_VALUE)
public interface RemoteService {
	
	@GetExchange(value = "order/remote")
	Mono<String> remote();
	

}
