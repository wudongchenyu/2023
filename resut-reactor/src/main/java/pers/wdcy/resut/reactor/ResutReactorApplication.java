package pers.wdcy.resut.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EntityScan(basePackages = "pers.wdcy.result.reactor.entity")
@EnableR2dbcRepositories(basePackages = "pers.wdcy.result.reactor.repository")
@SpringBootApplication
public class ResutReactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResutReactorApplication.class, args);
	}

}
