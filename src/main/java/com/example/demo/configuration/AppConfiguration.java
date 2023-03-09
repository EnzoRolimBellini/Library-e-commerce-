package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@EntityScan(basePackages = "com.example.demo.model")
public class AppConfiguration {
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Value("${spring.datasource.driver-class-name}")
	String driver;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	String ddl;
	
}
