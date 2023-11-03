package pers.wdcy.domanial.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserPayStrategyFactory {
	
	private static Map<String, UserPayService> services = new ConcurrentHashMap<>();

	public static void register(String type, UserPayService userPayService) {
		services.put(type, userPayService);
	}

	public static UserPayService getByUserType(String type) {
		return services.get(type);
	}

}
