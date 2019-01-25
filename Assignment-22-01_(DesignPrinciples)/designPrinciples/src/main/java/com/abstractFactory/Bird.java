package com.abstractFactory;

public class Bird implements Animal{

	public void breath() {
		System.out.println("Birds breath using two sets of air sacs, caudal air sacs and cranial air sacs!");
	}

	public void eat() {
		System.out.println("Birds eat bugs, worms and insects!");
	}

}
