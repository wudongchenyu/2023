package pres.wdcy.check.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import jakarta.annotation.Resource;
import pres.wdcy.check.annotatiom.Limit;
import reactor.core.publisher.Mono;

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
public class LimitFilter implements WebFilter{
	
	@Resource
    private RequestMappingHandlerMapping mapping;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		Mono<HandlerMethod> cast = mapping.getHandler(exchange).cast(HandlerMethod.class);
		cast.subscribe(handlerMethod -> {
			
			if (handlerMethod.hasMethodAnnotation(Limit.class)) {
				Limit limit = handlerMethod.getMethodAnnotation(Limit.class);
				System.out.println("注解限制：" + limit.value());
			}
			
		}).dispose();
		return chain.filter(exchange);
	}
}
