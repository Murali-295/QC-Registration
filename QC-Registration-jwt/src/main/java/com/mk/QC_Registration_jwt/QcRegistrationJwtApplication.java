package com.mk.QC_Registration_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class QcRegistrationJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(QcRegistrationJwtApplication.class, args);
	}

}
