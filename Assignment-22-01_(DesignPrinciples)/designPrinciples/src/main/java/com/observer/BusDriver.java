package com.observer;

//Observer implementation 
public class BusDriver extends Driver{

	public BusDriver(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
		this.trafficLight.add(this);
	}
	@Override
	public void update() {
		switch(trafficLight.getState()) {
		case RED:
			System.out.println("Bus has stopped at red light!");
			break;
		
		case YELLOW:
			System.out.println("Bus has slowed down at yellow light!");
			break;
		case GREEN:
			System.out.println("Bus has started moving at green light!");
			break;
		}
	}

}