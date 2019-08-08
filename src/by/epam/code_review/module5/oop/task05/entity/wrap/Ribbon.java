package by.epam.code_review.module5.oop.task05.entity.wrap;

import by.epam.code_review.module5.oop.task05.entity.Color;

public class Ribbon extends Wrap {

	private double length;

	public Ribbon(Color color) {
		super(color);
		this.length = 0.5;
		type = WrapType.RIBBON;
	}

	public Ribbon(Color color, double length) {
		super(color);
		this.length = length;
		type = WrapType.RIBBON;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}


	@Override
	public double getRandomPrice() {
		return random.nextInt(5) + length * 0.5;
	}

	@Override
	public String toString() {
		return super.toString() + " " + type.getName()
		                                    .toLowerCase() + " " + length + "m long, price = " + getPrice() + "$";
	}
}
