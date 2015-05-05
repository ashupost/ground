package com.ground.wrapper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.ground.ApplicationConfiguration;
import com.ground.service.database.configuration.DatabaseConfiguration;
import com.mkyong.hello.AppConfig;

@Configuration
@Import({DatabaseConfiguration.class, ApplicationConfiguration.class, AppConfig.class})
@PropertySource("classpath:properties/configurations.properties")
public class WrapperConfiguration  {
	// @ImportResource("classpath*:spring-xml/spring-config.xml")
	
	@Autowired 
	AppConfig appConfig;
	
	@Autowired 
	ApplicationConfiguration applicationConfiguration;

	@Autowired
	private Environment environment;
	
	@Bean
    public AwareBean awareBean() {
        return new AwareBean();
    }
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }

}