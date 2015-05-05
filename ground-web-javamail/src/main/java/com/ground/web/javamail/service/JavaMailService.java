package com.ground.web.javamail.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.ground.web.javamail.configuration.Sender;

@Path("/javamail")
public class JavaMailService {

	@Autowired
	Sender sender;

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg111(@PathParam("param") String msg1) {
    
		SimpleMailMessage bean = new SimpleMailMessage();
		bean.setFrom("groundapp123@gmail.com");
		bean.setTo("ashupost@gmail.com");
		bean.setSubject("Subject");
		
		
		Map<String, Object> hTemplateVariables = new HashMap<String, Object>();
		User user = new User();
		user.setEmailAddress("KKKKKKKK@gmail.com");
		user.setUserName("UserName");
		hTemplateVariables.put("user", user);
		
		sender.send(bean, hTemplateVariables);
		
		
		
		return Response.status(200).entity("status").build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg112(@Context HttpHeaders context) {
		String host= context.getRequestHeaders().getFirst("Host");
		System.out.println("Hots="+host);
		return Response.status(200).entity(host).build();
	}

}


