package by.epam.code_review.module5.oop.task05.entity;

import java.util.Random;

public abstract class Entity {

	private static int genId = 1;
	private int id;
	private Color color;
	private double price;
	public static Random random = new Random();

	public Entity() {
		this.id = genId++;
		this.color = Color.RED;
		this.price = 5.0;
	}

	public Entity(Color color) {
		this();
		this.color = color;
		this.price = getRandomPrice();
	}

	public int getId() {
		return id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract double getRandomPrice();

	@Override
	public String toString() {
		return "The " + getColor().getName().toLowerCase();
	}
}
