package com.abstractFactory;

public class FishFactory extends AbstractFactory{

	@Override
	Animal getAnimal() {
		return new Fish();
	}

}
