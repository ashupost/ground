package com.ground.web.services.soap.application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class WebServicesServerApplication extends ResourceConfig {

	public WebServicesServerApplication() {
		register(JacksonFeature.class);
	}

}
