package com.ground.web.services.soap.client.publisher;

import javax.xml.ws.Endpoint;

import com.ground.web.services.soap.client.serviceimpl.HelloWorldServiceImpl;

//Endpoint publisher
public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9991/ws/hello", new HelloWorldServiceImpl());
	}

}