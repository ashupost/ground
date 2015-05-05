package com.mkyong.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ground.ApplicationConfiguration;
import com.ground.service.database.configuration.DatabaseConfiguration;

@Configuration
@ComponentScan("com.mkyong.ws")
@Import({ DatabaseConfiguration.class, ApplicationConfiguration.class })
public class AppConfig {

	@Bean(name = "helloBean")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}
}