package com.ground.wrapper.filter;

import java.io.Serializable;

public class Pair implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String keyId;
	private String keyValue;
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	

}
