package by.epam.code_review.module5.oop.task05.entity.wrap;

import by.epam.code_review.module5.oop.task05.entity.Color;
import by.epam.code_review.module5.oop.task05.entity.Entity;

public abstract class Wrap extends Entity {

	protected WrapType type;

	public Wrap() {
		super();
	}

	public Wrap(Color color) {
		super(color);
	}

	public WrapType getType() {
		return type;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Wrap wrap = (Wrap) o;

		if (getColor() != wrap.getColor()) return false;
		return type == wrap.type;
	}

	@Override
	public int hashCode() {
		int result = getColor().hashCode();
		result = result * 31 + type.hashCode();
		return result;
	}
}
