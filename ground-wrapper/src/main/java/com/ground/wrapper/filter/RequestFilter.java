package com.ground.wrapper.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class RequestFilter implements ContainerRequestFilter {
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private Environment environment;
	
	@Override
	public void filter(ContainerRequestContext requestContext) 	throws IOException {
		boolean wrapperEnable = Boolean.parseBoolean(environment.getProperty("wrapper.enable"));
		if(wrapperEnable){
			SetWrapperProperties.setRequestHeader(requestContext, environment);
			SetWrapperProperties.setSessionAttributes(request, environment);
		}
		
		UriInfo info =requestContext.getUriInfo();
		if(info != null){
			if(info.getPath().equals("/wrapper/session")){
				requestContext.abortWith(Response.status(Status.OK).entity("JJJJJJJ").build());
			}
		}
		System.out.println(info.getPath());
		
	}
}
