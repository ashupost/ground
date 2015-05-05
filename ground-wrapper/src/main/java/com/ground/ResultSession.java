package com.ground;

import java.io.Serializable;

public class ResultSession implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sessionKey;
	
	private String sessionValue;

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getSessionValue() {
		return sessionValue;
	}

	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}

	

}
