package pers.wdcy.domanial.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class VipPayService extends UserPayTemplate{

	private static final String type = "Vip";
	
	public VipPayService() {
		super(type);
	}
	
	@Override
	public BigDecimal quotePric(BigDecimal orderPrice) {
		return orderPrice.multiply(new BigDecimal(0.9));
	}

}
