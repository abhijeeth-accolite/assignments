package com.observer;

// Observer implementation 
public class CarDriver extends Driver{

	public CarDriver(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
		this.trafficLight.add(this);
	}
	@Override
	public void update() {
		switch(trafficLight.getState()) {
		case RED:
			System.out.println("Car has stopped at red light!");
			break;
		
		case YELLOW:
			System.out.println("Car has slowed down at yellow light!");
			break;
		case GREEN:
			System.out.println("Car has started moving at green light!");
			break;
		}
	}

}
