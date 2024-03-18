package pres.wdcy.check.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pres.wdcy.check.annotatiom.Limit;
import reactor.core.publisher.Mono;

@RestController
public class AnnotationController {
	
	@Limit(3)
	@GetMapping("/")
	public Mono<String> name() {
		return Mono.just("1");
	}

}
