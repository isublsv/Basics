package by.etc.code_review.oop.task04.entity.armor;

import by.etc.code_review.oop.task04.entity.Treasure;

public class Armor extends Treasure {

	private int defence;

	public Armor() {
		this.defence = setRandomParameter();
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	@Override
	public void setRandomName() {
		int value = getRandom().nextInt(ArmorType.values().length);
		ArmorType[] types = ArmorType.values();
		setName(types[value].getName());
	}

	@Override
	public int setRandomParameter() {
		return getRandom().nextInt(50) + 10;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t defence %s,\t %d gold", getId(), getName(), defence, getValue());
	}
}
