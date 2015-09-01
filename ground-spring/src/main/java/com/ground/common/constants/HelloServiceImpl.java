package com.ground.common.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import com.ground.Loggable;
public class HelloServiceImpl implements HelloService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Override
	@Cacheable(value="movieFindCache", key="#name")
	public String getName(String name) {
		 slowQuery(1L);
		//System.out.println("findByDirector is running...");
		return "Hello " + name;
	}
	
	private void slowQuery(long seconds){
	    try {
                
	    	Thread.sleep(seconds);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
	}

	@Override
	@Loggable
	public String getGreeting1(String message) {
		// TODO Auto-generated method stub
		return "GGGGGGGGG " + message;
	}

}
