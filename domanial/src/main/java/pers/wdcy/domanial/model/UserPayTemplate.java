package pers.wdcy.domanial.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.InitializingBean;

public abstract class UserPayTemplate implements UserPayService, InitializingBean{

	private String type;
	
	public UserPayTemplate(String type) {
		this.type = type;
	}
	
	@Override
	public abstract BigDecimal quotePric(BigDecimal orderPrice);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		UserPayStrategyFactory.register(type, this);
	}
	
}
