package pers.wdcy.resut.reactor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.wdcy.resut.reactor.result.Result;
import pers.wdcy.resut.reactor.service.ResultService;
import reactor.core.publisher.Mono;

@RestController
public class ResultController {
	
	private @Autowired ResultService resultService;
	
	@GetMapping(path = "increase/order")
	public Mono<Result<Boolean>> increaseOrder() {
		return resultService.increaseOrder();
	}

}
