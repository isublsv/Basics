package by.etc.code_review.oop.task05.entity.wrap;

public enum Density {
	HIGH(1),
	MIDDLE(0.6),
	LOW(0.2);

	private double value;

	Density(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
