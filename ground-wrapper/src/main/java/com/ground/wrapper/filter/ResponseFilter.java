package com.ground.wrapper.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@Priority(Priorities.HEADER_DECORATOR)
public class ResponseFilter implements ContainerResponseFilter {
	@Context
	private HttpServletResponse response;
	//private HttpSession session = request.getSession(); 
	
	@Context
	private HttpServletRequest request;
	
	@Autowired
	private Environment environment;
	
	
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

		responseContext.getHeaders().add("X-Powered-By1", "Jersey :-)");
		Cookie myCookie = new Cookie("name", "val");
		
		response.addCookie(myCookie);
		
		SetWrapperProperties.setRequestHeader(requestContext, environment);
		SetWrapperProperties.setSessionAttributes(request, environment);
		
		// System.out.println("project.namer res ="+ this.environment.getProperty("project.name"));
		
	}
}