package dev.mvc.checksched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.mvc","dev.mvc.admin", "dev.mvc.checksched"})
public class CheckSchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckSchedApplication.class, args);
	}

}
