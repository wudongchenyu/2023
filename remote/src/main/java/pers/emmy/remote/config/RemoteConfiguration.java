package pers.emmy.remote.config;

import java.time.Duration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import reactor.netty.http.client.HttpClient;

@Configuration(proxyBeanMethods = false)
public class RemoteConfiguration {
	
	//使用微服务调用时使用LoadBalanced
	@LoadBalanced
	@Bean
	WebClient.Builder microBuilder() {
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(
				HttpClient.create().proxyWithSystemProperties().responseTimeout(Duration.ofSeconds(2))))
				.codecs(item->item.defaultCodecs().maxInMemorySize(10 * 1024 * 1024));
	}
	
	@Bean
	WebClient.Builder builder() {
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(
				HttpClient.create().proxyWithSystemProperties().responseTimeout(Duration.ofSeconds(2))))
				.codecs(item->item.defaultCodecs().maxInMemorySize(10 * 1024 * 1024));
	}
	
	@Bean
	HttpServiceProxyFactory factory(WebClient.Builder builder) {
		WebClient client = builder
				//使用loadBlanced时不能使用IP，需要使用服务名
				.baseUrl("http://localhost:8081")
				.build();
		return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
	}

}
