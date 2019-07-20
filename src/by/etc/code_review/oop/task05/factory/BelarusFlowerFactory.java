package by.etc.code_review.oop.task05.factory;

import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.flower.Piony;
import by.etc.code_review.oop.task05.entity.flower.Rose;
import by.etc.code_review.oop.task05.entity.flower.Tulip;

public class BelarusFlowerFactory implements FlowerAbstractFactory {

	public static final String PRODUCER = "Belarus";

	@Override
	public Rose createRose(Color color) {
		return new Rose(color, PRODUCER);
	}

	@Override
	public Tulip createTulip(Color color) {
		return new Tulip(color, PRODUCER);
	}

	@Override
	public Piony createPiony(Color color) {
		return new Piony(color, PRODUCER);
	}

}
