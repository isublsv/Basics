package by.etc.code_review.oop.task05.entity.flower;

import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.Entity;

public abstract class Flower extends Entity {

	protected FlowerType type;
	private String producer;

	public Flower() {
		super();
		producer = "Belarus";
	}

	public Flower(Color color, String producer) {
		super(color);
		this.producer = producer;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public FlowerType getType() {
		return type;
	}

	@Override
	public String toString() {
		return super.toString() + " " + producer + " " + type.getName().toLowerCase() + ", price = " + getPrice() + "$";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Flower flower = (Flower) o;

		if (type != flower.type) return false;
		if (getColor() != flower.getColor()) return false;
		return producer != null ? producer.equals(flower.producer) : flower.producer == null;
	}

	@Override
	public int hashCode() {
		int result =  type.hashCode();
		result = 31 * result + getColor().hashCode();
		result += producer.hashCode();
		return result;
	}
}
