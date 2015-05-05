package com.ground;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.mkyong.rest.HelloWorldService;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		
		register(JacksonFeature.class);
		register(HelloWorldService.class);
		register(MyObjectMapperProvider.class);
		
		
	}
	
}
