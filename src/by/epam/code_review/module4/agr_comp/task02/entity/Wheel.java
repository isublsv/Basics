package by.epam.code_review.module4.agr_comp.task02.entity;

public class Wheel {

	private int radius;

	public Wheel(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Wheel{" + "radius=" + radius + '}';
	}
}
