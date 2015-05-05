package com.ground;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.ground.wrapper.filter.RequestFilter;
import com.ground.wrapper.filter.ResponseFilter;
import com.mkyong.rest.HelloWorldService;
import com.mkyong.rest.WrapperService;

public class WrapperApplication extends ResourceConfig {

	public WrapperApplication() {
		register(JacksonFeature.class);
		register(WrapperService.class);
		register(MyObjectMapperProvider.class);
		register(RequestFilter.class);
		register(ResponseFilter.class);
		register(HelloWorldService.class);
		
		
		//HelloWorldService
		
		
	}
	
}
