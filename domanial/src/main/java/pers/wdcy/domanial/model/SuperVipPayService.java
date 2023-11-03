package pers.wdcy.domanial.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class SuperVipPayService extends UserPayTemplate{

	private static final String type = "SuperVip";
	
	public SuperVipPayService() {
		super(type);
	}
	
	@Override
	public BigDecimal quotePric(BigDecimal orderPrice) {
		return orderPrice.multiply(new BigDecimal(0.8));
	}

}
