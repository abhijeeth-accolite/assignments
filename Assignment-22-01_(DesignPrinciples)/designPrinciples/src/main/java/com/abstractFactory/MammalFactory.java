package com.abstractFactory;

public class MammalFactory extends AbstractFactory{

	@Override
	Animal getAnimal() {
		return new Mammal();
	}

}
