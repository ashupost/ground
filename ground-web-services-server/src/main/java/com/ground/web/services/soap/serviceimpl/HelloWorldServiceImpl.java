package com.ground.web.services.soap.serviceimpl;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.ground.web.services.soap.exception.GroundSoapException;
import com.ground.web.services.soap.model.HelloWorldResponse;
import com.ground.web.services.soap.model.StatusType;
import com.ground.web.services.soap.service.HelloWorldService;

@WebService(endpointInterface = "com.ground.web.services.soap.service.HelloWorldService", serviceName = "HelloWorldServiceName", name = "HelloWorldName", portName = "HelloWorldPortName", targetNamespace = "http://www.ground.com")
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	public HelloWorldResponse getHelloWorldAsString(String name) throws GroundSoapException {

		HelloWorldResponse response = new HelloWorldResponse();

		response.setResult("Hello World JAX-WS " + name);

		response.setStatus(StatusType.OK);

		return response;
	}

}