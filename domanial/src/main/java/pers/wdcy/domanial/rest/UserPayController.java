package pers.wdcy.domanial.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.wdcy.domanial.model.PayService;

@RestController
public class UserPayController {
	
	private @Autowired PayService payService;
	
	@GetMapping(path = "/")
	public void name() {
		payService.name();
	}

}
