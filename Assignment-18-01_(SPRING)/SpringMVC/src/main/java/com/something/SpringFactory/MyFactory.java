package com.something.SpringFactory;

public class MyFactory {
	public MyInterface getMyInterfaceObject() {
		return new MyClass();
	}
}
