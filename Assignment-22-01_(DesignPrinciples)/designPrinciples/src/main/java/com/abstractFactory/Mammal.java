package com.abstractFactory;

public class Mammal implements Animal {

	public void breath() {
		System.out.println("Mammals breath using paired lungs!");
	}

	public void eat() {
		System.out.println("Mammals eat fruits and vegetables!");
	}

}
