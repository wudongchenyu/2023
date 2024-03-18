package pres.wdcy.check;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pres.wdcy.check")
public class CheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckApplication.class, args);
	}

}
