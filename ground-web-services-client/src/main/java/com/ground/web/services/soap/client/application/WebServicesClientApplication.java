package com.ground.web.services.soap.client.application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class WebServicesClientApplication extends ResourceConfig {

	public WebServicesClientApplication() {
		register(JacksonFeature.class);
	}

}
