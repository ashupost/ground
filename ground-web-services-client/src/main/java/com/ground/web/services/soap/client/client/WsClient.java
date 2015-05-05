package com.ground.web.services.soap.client.client;

import com.ground.generated.source.wsdl.HelloWorldService;
import com.ground.generated.source.wsdl.HelloWorldServiceService;

public class WsClient{
	 
	public static void main(String[] args) throws Exception {
 
		HelloWorldServiceService sis = new HelloWorldServiceService();
		HelloWorldService si = sis.getHelloWorldServicePort();
 
		System.out.println(si.getHelloWorldAsStringOperationName("Kumar"));
 
    }
 
}