package by.etc.code_review.oop.task05.entity.flower;

import by.etc.code_review.oop.task05.entity.Color;

import java.util.Random;

public abstract class Flower {

	private static int genId = 1;
	private int id;
	private Color color;
	private String producer;
	protected FlowerType type;
	private double price;
	public static Random random = new Random();

	public Flower() {
		color = Color.RED;
		producer = "Belarus";
		type = FlowerType.ROSE;
		price = 5.0;
	}

	public Flower(Color color, String producer) {
		this.id = genId++;
		this.color = color;
		this.producer = producer;
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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public FlowerType getType() {
		return type;
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
		return "The " + color.getName().toLowerCase() + " " + producer + " " + type.getName()
		                                                                           .toLowerCase() + ", price = " + price;
	}
}
