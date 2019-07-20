package by.etc.code_review.oop.task05.utils;

import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.flower.Flower;
import by.etc.code_review.oop.task05.entity.flower.FlowerType;
import by.etc.code_review.oop.task05.factory.BelarusFlowerFactory;
import by.etc.code_review.oop.task05.factory.FlowerAbstractFactory;
import by.etc.code_review.oop.task05.factory.HollandFlowerFactory;

public class FlowerGenerator implements Generator<Flower>{

	private FlowerAbstractFactory factory;

	public FlowerGenerator(String producer) {
		setFactory(producer);
	}

	@Override
	public Flower next() {
		return getRandomFlower(Generator.getRandomColor(), getRandomType());
	}

	@Override
	public String getRandomType() {
		FlowerType type = FlowerType.values()[random.nextInt(FlowerType.values().length)];
		return type.name();
	}

	private void setFactory(String producer) {
		String sign = producer.toUpperCase().trim();
		switch (sign) {
			case "HOLLAND":
				factory = new HollandFlowerFactory();
				break;
			case "BELARUS":
				factory = new BelarusFlowerFactory();
				break;
			default:
				throw new IllegalArgumentException("Wrong argument: " + producer);
		}
	}

	private Flower getRandomFlower(Color color, String type) {
		FlowerType sign = FlowerType.valueOf(type);
		switch (sign) {
			case ROSE:
				return factory.createRose(color);
			case TULIP:
				return factory.createTulip(color);
			case PIONY:
				return factory.createPiony(color);
			default:
				throw new IllegalArgumentException("Wrong argument: " + random);
		}
	}
}
