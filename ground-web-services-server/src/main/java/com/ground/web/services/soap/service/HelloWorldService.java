package com.ground.web.services.soap.service;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.ground.web.services.soap.exception.GroundSoapException;
import com.ground.web.services.soap.model.HelloWorldResponse;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
@HandlerChain(file = "../../../../../../handler-chain.xml")
public interface HelloWorldService {

	@WebMethod(action = "urn:getHelloWorldAsStringAction", operationName = "getHelloWorldAsStringOperationName", exclude = false)
	@WebResult(partName = "lookupOutput", name = "HelloWorldResponse")
	HelloWorldResponse getHelloWorldAsString(@WebParam(partName = "lookupInput") String name) throws GroundSoapException;
}