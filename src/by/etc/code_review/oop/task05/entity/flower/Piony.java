package by.etc.code_review.oop.task05.entity.flower;

import by.etc.code_review.oop.task05.entity.Color;

public class Piony extends Flower {

	public Piony(Color color, String producer) {
		super(color, producer);
		type = FlowerType.PIONY;
	}

	@Override
	public double getRandomPrice() {
		return random.nextInt(5) + 1;
	}
}
