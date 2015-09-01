package com.ground.anonymous;

public class FruitImpl implements Fruit {
	
	private String name;
	
	public FruitImpl(String name){
		this.name=name;
		
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}
