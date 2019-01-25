package com.observer;

import java.util.ArrayList;
import java.util.List;

// Subject
public class TrafficLight {
	private List<Driver> drivers = new ArrayList<>();
    private TrafficLightState state;

    public void add(Driver driver) {
        drivers.add(driver);
    }

    public TrafficLightState getState() {
        return state;
    }

    public void setState(TrafficLightState value) {
        this.state = value;
        execute();
    }

    private void execute() {
        for (Driver driver : drivers) {
            driver.update();
        }
    }
}
