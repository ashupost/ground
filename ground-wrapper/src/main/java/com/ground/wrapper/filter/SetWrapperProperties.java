package com.ground.wrapper.filter;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.core.env.Environment;

public class SetWrapperProperties {

	public static void setRequestHeader(ContainerRequestContext requestContext, Environment environment) {
		final boolean requestUse = Boolean.parseBoolean(environment.getProperty("request.use"));
		final String requestHeader = environment.getProperty("request.header");
		if (requestUse) {
			StringTokenizer st2 = new StringTokenizer(requestHeader, ",");
			final MultivaluedMap<String, String> malutiValued = requestContext.getHeaders();
			String key, value;
			StringTokenizer st3;
			while (st2.hasMoreElements()) {
				st3 = new StringTokenizer((String) st2.nextElement(), "=");
				while (st3.hasMoreElements()) {
					key = (String) st3.nextElement();
					value = (String) st3.nextElement();
					if (!malutiValued.containsKey(key)) {
						requestContext.getHeaders().add(key, value);
					}
				}
			}
		}
	}

	public static void setSessionAttributes(HttpServletRequest request, Environment environment) {
		HttpSession session = request.getSession();
		final boolean sessionUse = Boolean.parseBoolean(environment.getProperty("session.use"));
		final String sessionProperties = environment.getProperty("session.properties");
		if (sessionUse) {
			final StringTokenizer st2 = new StringTokenizer(sessionProperties, ",");
			String key, value, sessionAtt;
			StringTokenizer st3;
			while (st2.hasMoreElements()) {
				st3 = new StringTokenizer((String) st2.nextElement(), "=");
				while (st3.hasMoreElements()) {
					key = (String) st3.nextElement();
					value = (String) st3.nextElement();
					sessionAtt = (String) session.getAttribute(key);
					if (sessionAtt == null) {
						session.setAttribute(key, value);
					}
				}
			}
		}
	}

	public static void main(String[] arg) {

	}

}
