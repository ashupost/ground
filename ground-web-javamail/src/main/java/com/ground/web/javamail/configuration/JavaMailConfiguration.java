package com.ground.web.javamail.configuration;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.ground.ApplicationConfiguration;
import com.ground.service.database.configuration.DatabaseConfiguration;
import com.mkyong.hello.HelloWorld;
import com.mkyong.hello.HelloWorldImpl;

@Configuration
@Import({ DatabaseConfiguration.class, ApplicationConfiguration.class })
@ComponentScan("com.ground.web.javamail.configuration")
public class JavaMailConfiguration {

	@Bean(name = "helloBean")
	public HelloWorld helloWorld() {
		return new HelloWorldImpl();
	}


	@Bean
	public SimpleMailMessage templateMessage() {
		SimpleMailMessage bean = new SimpleMailMessage();
		bean.setFrom("groundapp123@gmail.com");
		bean.setTo("ashupost@gmail.com");
		bean.setSubject("Subject");
		return bean;
	}

	@Bean
	public VelocityEngineFactoryBean velocityEngine() {
		VelocityEngineFactoryBean bean = new VelocityEngineFactoryBean();
		
		bean.setVelocityProperties(getVal());
		//bean.setResourceLoaderPath("classpath:/com.ground.web.javamail.configuration");
		//bean.setPreferFileSystemAccess(false);
		return bean;
	}
	
	private Properties getVal() {
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "class");
		properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		return properties;
		
	}

	private Session session() {
		Session session = Session.getInstance(getMailProperties(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("groundapp123@gmail.com", "Madhubani@123");
					}
				});
		return session;
	}

	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		//javaMailSender.setHost("smtp.gmail.com");
		//javaMailSender.setPort(587);
		javaMailSender.setSession(session());
		//javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		
		
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.debug", "true");
		return properties;
	}

}