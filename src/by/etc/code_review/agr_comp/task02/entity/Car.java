package by.etc.code_review.agr_comp.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {

	private String model;
	private Engine engine;
	private List<Wheel> wheels;
	private boolean haveFuel = false;
	private boolean isMoving = false;

	public Car(String model, Engine engine) {
		this.model = model;
		this.engine = engine;
		this.wheels = new ArrayList<>();

	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public boolean addWheel(Wheel wheel) {
		return wheels.add(wheel);
	}

	@Override
	public void move() {
		if (wheels.size() != 4) {
			System.out.println("Wrong number of wheels!");
		} else if (!haveFuel) {
			System.out.println("There are no fuel!");
		} else {
			System.out.println("The car " + model + " is moving.");
			isMoving = true;
		}
	}

	@Override
	public void fuelUp() {
		if (isMoving) {
			System.out.println("Stop the car if you want to fuel up!");
		} else {
			System.out.println("The car " + model + " is fuel up.");
			this.haveFuel = true;
		}
	}

	@Override
	public void changeWheel() {
		if (isMoving) {
			System.out.println("Stop the car if you want to change the wheel!");
		}else {
			System.out.println("Change wheel!");
		}
	}

	@Override
	public void printModel() {
		System.out.println(model);
	}
}
