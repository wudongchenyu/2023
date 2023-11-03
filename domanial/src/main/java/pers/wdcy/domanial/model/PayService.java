package pers.wdcy.domanial.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class PayService {
	
	public void name() {
		String type1 = "particularlyVip";
		UserPayService userPayService = UserPayStrategyFactory.getByUserType(type1);
		BigDecimal quotePric = userPayService.quotePric(new BigDecimal(300));
		System.out.println("particularlyVip会员商品最终价格为:" + quotePric.doubleValue());
		
		String type2 = "Vip";
		UserPayService userPayService2 = UserPayStrategyFactory.getByUserType(type2);
		BigDecimal quotePric2 = userPayService2.quotePric(new BigDecimal(300));
		System.out.println("Vip会员商品最终价格为:" + quotePric2.doubleValue());
		
		String type3 = "SuperVip";
		UserPayService userPayService3 = UserPayStrategyFactory.getByUserType(type3);
		BigDecimal quotePric3 = userPayService3.quotePric(new BigDecimal(300));
		System.out.println("SuperVip会员商品最终价格为:" + quotePric3.doubleValue());
	}

}
