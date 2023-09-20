package pers.emmy.remote.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import pers.emmy.remote.service.RemoteService;
import reactor.core.publisher.Mono;

@RestController
public class RemoteController {
	
	private @Autowired RemoteService remoteService;
	
	@GetMapping(path = "/name")
	public Mono<String> name() {
		return remoteService.remote();
	}
	
	@GetMapping(path = "/baidu")
	public Mono<String> baidu() {
		WebClient client = WebClient.builder()
				.codecs(item->item.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
				.baseUrl("http://www.baidu.com").build();
		return client.get().uri("").accept(MediaType.TEXT_HTML)
				.exchangeToMono(response -> {
					return response.bodyToMono(String.class);
				});
	}
	
	@GetMapping(path = "/remote")
	public Mono<Boolean> remote() {
		WebClient client = WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_NDJSON_VALUE)
				.codecs(item->item.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
				.baseUrl("http://127.0.0.1:8081").build();
		return client.get().uri("order/remote").accept(MediaType.APPLICATION_NDJSON)
				.exchangeToMono(response -> {
					return response.bodyToMono(Boolean.class);
				});
	}

}
