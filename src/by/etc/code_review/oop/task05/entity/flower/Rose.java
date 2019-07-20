package by.etc.code_review.oop.task05.entity.flower;

import by.etc.code_review.oop.task05.entity.Color;

public class Rose extends Flower {

	public Rose(Color color, String producer) {
		super(color, producer);
		type = FlowerType.ROSE;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(10) + 5;
	}
}
