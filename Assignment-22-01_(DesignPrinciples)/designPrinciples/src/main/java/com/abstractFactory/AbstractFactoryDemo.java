package com.abstractFactory;

public class AbstractFactoryDemo {
	public static void main(String[] args) {
		AbstractFactory mammalFactory = FactoryProducer.getFactory("mammal");
		AbstractFactory fishFactory = FactoryProducer.getFactory("fish");
		AbstractFactory birdFactory = FactoryProducer.getFactory("bird");
		
		Animal mammal = mammalFactory.getAnimal();
		Animal fish = fishFactory.getAnimal();
		Animal bird = birdFactory.getAnimal();
		
		mammal.breath();
		fish.breath();
		bird.breath();
		
		mammal.eat();
		fish.eat();
		bird.eat();
	}
}
