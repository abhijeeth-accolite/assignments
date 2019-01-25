package com.observer;

public class ObserverDemo {
	public static void main( String[] args ) {
        TrafficLight trafficLight = new TrafficLight();
        new CarDriver(trafficLight);
        new BusDriver(trafficLight);
        trafficLight.setState(TrafficLightState.YELLOW);
        trafficLight.setState(TrafficLightState.RED);
        trafficLight.setState(TrafficLightState.GREEN);
    }
}
