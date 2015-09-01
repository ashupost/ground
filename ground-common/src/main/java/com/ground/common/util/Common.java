package com.ground.common.util;

import java.util.*;

interface Curlable {
	public void curl();
}

abstract class Animal {
	protected abstract String name();
}

class Dog extends Animal {
	public String name() {
		return ("Dog");
	}
}

class Poodle extends Dog {
	public String name() {
		return ("Poodle");
	}
}

class ShortHair extends Poodle implements Curlable {
	public String name() {
		return ("ShortHair");
	}

	public void curl() {
		System.out.println("This shorthair poodle can be curled.");
	}

}

class Cat extends Animal {
	public String name() {
		return ("Cat");
	}
}

public class Common {

	public static void addToList(List<? super ShortHair> list, ShortHair shortHair) {
		list.add(shortHair);
	}

	public static void iterate(List<? extends Animal> list) {
		for (Animal animal : list)
			System.out.println(animal.name());
	}

	public static void iterateCurlable(List<? extends Curlable> list) {
		for (Curlable curlable : list)
			curlable.curl();
		
		
		
		
	}

	public static void main(String[] args) {
		List<Animal> list = new ArrayList<Animal>();
		List<Dog> list1 = new ArrayList<Dog>();
		List<Poodle> list2 = new ArrayList<Poodle>();
		List<Curlable> list3 = new ArrayList<Curlable>();

		addToList(list, new ShortHair());
		addToList(list1, new ShortHair());
		addToList(list2, new ShortHair());
		addToList(list3, new ShortHair());

		//iterate(list);
		//iterate(list1);
		//iterate(list2);
		iterateCurlable(list3);
	}

}