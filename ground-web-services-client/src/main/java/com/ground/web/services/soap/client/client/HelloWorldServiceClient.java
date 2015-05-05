package com.ground.web.services.soap.client.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.ground.web.services.soap.client.service.HelloWorldService;
 
public class HelloWorldServiceClient{
 
	public static void main(String[] args) throws Exception {
 
	URL url = new URL("http://localhost:9999/HelloWorldServiceName?wsdl");
 
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://www.ground.com", "HelloWorldServiceName");
 
        Service service = Service.create(url, qname);
 
        HelloWorldService hello = service.getPort(HelloWorldService.class);
 
        System.out.println(hello.getHelloWorldAsString("Mkumar"));
 
    }
 
}