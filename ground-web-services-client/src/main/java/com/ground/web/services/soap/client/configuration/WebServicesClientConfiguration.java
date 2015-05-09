package com.ground.web.services.soap.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import com.ground.ApplicationConfiguration;
import com.ground.service.database.configuration.DatabaseConfiguration;

@Configuration
@ComponentScan("com.ground.web.services.soap")
@Import({ DatabaseConfiguration.class, ApplicationConfiguration.class })
public class WebServicesClientConfiguration {

	@Bean
	public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
		SimpleJaxWsServiceExporter simpleJaxWsServiceExporter = new SimpleJaxWsServiceExporter();
		simpleJaxWsServiceExporter.setBaseAddress("http://localhost:9999/");
		return simpleJaxWsServiceExporter;
	}

}