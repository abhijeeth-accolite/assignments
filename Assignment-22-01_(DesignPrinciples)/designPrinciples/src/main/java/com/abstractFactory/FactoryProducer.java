package com.abstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String requiredFactory) {
		switch (requiredFactory) {
		case "fish":
			return new FishFactory();
		case "mammal":
			return new MammalFactory();
		case "bird":
			return new BirdFactory();
		default:
			return null;
		}
	}
}
