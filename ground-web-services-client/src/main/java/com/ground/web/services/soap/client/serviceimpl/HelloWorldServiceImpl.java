package com.ground.web.services.soap.client.serviceimpl;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.ground.web.services.soap.client.exception.GroundSoapException;
import com.ground.web.services.soap.client.model.HelloWorldResponse;
import com.ground.web.services.soap.client.model.StatusType;
import com.ground.web.services.soap.client.service.HelloWorldService;

@WebService(endpointInterface = "com.ground.web.services.soap.service.HelloWorldService", serviceName = "HelloWorldServiceName", name = "HelloWorldName", portName = "HelloWorldPortName", targetNamespace = "http://www.ground.com")
@Service(value = "ABC")
@HandlerChain(file = "com/ground/web/services/soap/handler/handler-chain.xml")
public class HelloWorldServiceImpl implements HelloWorldService {

	public HelloWorldResponse getHelloWorldAsString(String name) throws GroundSoapException {

		HelloWorldResponse response = new HelloWorldResponse();

		response.setResult("Hello World JAX-WS " + name);

		response.setStatus(StatusType.OK);

		return response;
	}

}