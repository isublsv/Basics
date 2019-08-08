package by.epam.code_review.module5.oop.task05.entity.flower;

import by.epam.code_review.module5.oop.task05.entity.Color;

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
