package com.silence.app.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SilenceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilenceSecurityApplication.class, args);
	}

}
