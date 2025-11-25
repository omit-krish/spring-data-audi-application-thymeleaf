package com.omitkrish.thymleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringDataAuditAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAuditAppApplication.class, args);
	}

}
