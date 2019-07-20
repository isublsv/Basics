package by.etc.code_review.oop.task05.entity.wrap;

import by.etc.code_review.oop.task05.entity.Color;

import java.util.Random;

public abstract class Wrap {

	private Color color;
	private double price;
	protected WrapType type;
	public static Random random = new Random();

	public Wrap() {
		color = Color.RED;
		price = 1.0;
		type = WrapType.PAPER;
	}

	public Wrap(Color color) {
		this.price = getRandomPrice();
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public WrapType getType() {
		return type;
	}

	public abstract double getRandomPrice();

	@Override
	public String toString() {
		return "The " + color.getName().toLowerCase();
	}
}
