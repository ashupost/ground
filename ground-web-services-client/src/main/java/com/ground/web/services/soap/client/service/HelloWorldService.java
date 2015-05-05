package com.ground.web.services.soap.client.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.ground.web.services.soap.client.exception.GroundSoapException;
import com.ground.web.services.soap.client.model.HelloWorldResponse;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorldService {

	@WebMethod(action = "getHelloWorldAsStringAction", operationName = "getHelloWorldAsStringOperationName", exclude = false)
	@WebResult(partName = "lookupOutput", name = "HelloWorldResponse")
	HelloWorldResponse getHelloWorldAsString(@WebParam(partName = "lookupInput") String name) throws GroundSoapException;
}