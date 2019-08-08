package by.epam.code_review.module5.oop.task05.entity.wrap;

import by.epam.code_review.module5.oop.task05.entity.Color;

public class Membrane extends Wrap {

	private Density density;

	public Membrane(Color color) {
		super(color);
		this.density = Density.MIDDLE;
		type = WrapType.MEMBRANE;
	}

	public Membrane(Color color, Density density) {
		super(color);
		this.density = density;
	}

	public Density getDensity() {
		return density;
	}

	public void setDensity(Density density) {
		this.density = density;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(3) + 1;
	}

	@Override
	public String toString() {
		return super.toString() + " " + type.getName()
		                                    .toLowerCase() + ", with density " + density.getValue() + "g/m2, price = " + getPrice() + "$";
	}
}
