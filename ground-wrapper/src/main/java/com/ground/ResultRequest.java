package com.ground;

import java.io.Serializable;

public class ResultRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String requestHeaderName;
	
	private String requestHeaderValue;

	public String getRequestHeaderName() {
		return requestHeaderName;
	}

	public void setRequestHeaderName(String requestHeaderName) {
		this.requestHeaderName = requestHeaderName;
	}

	public String getRequestHeaderValue() {
		return requestHeaderValue;
	}

	public void setRequestHeaderValue(String requestHeaderValue) {
		this.requestHeaderValue = requestHeaderValue;
	}
	

}
