package by.etc.code_review.oop.task05.entity.flower;

import by.etc.code_review.oop.task05.entity.Color;

public class Tulip extends Flower {

	public Tulip(Color color, String producer) {
		super(color, producer);
		type = FlowerType.TULIP;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(6) + 2;
	}
}
