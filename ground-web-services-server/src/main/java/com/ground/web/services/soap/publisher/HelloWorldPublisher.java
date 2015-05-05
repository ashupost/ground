package com.ground.web.services.soap.publisher;

import javax.xml.ws.Endpoint;

import com.ground.web.services.soap.serviceimpl.HelloWorldServiceImpl;

//Endpoint publisher
public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9991/ws/hello", new HelloWorldServiceImpl());
	}

}