package com.abstractFactory;

public class BirdFactory extends AbstractFactory{

	@Override
	Animal getAnimal() {
		return new Bird();
	}

}
