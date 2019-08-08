package by.epam.code_review.module5.oop.task04.entity.armor;

import by.epam.code_review.module5.oop.task04.entity.Treasure;

public class Armor extends Treasure {

	private int defence;

	public Armor() {
		this.defence = getRandomParameter();
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	@Override
	public void setRandomName() {
		int value = random.nextInt(ArmorType.values().length);
		ArmorType[] types = ArmorType.values();
		setName(types[value].getName());
	}

	@Override
	public int getRandomParameter() {
		return random.nextInt(50) + 10;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t defence %s,\t %d gold", getId(), getName(), defence, getValue());
	}
}
