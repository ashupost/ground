package com.ground.web.javamail.application;

import java.io.Serializable;

public class Country implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String capital;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	

}
