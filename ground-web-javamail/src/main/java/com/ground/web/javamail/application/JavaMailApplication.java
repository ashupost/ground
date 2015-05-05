package com.ground.web.javamail.application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.ground.web.javamail.service.JavaMailService;

public class JavaMailApplication extends ResourceConfig {

	public JavaMailApplication() {
		
		register(JacksonFeature.class);
		register(JavaMailService.class);
		register(MyObjectMapperProvider.class);
		
		
	}
	
}
