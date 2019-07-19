package by.etc.code_review.oop.task04.entity.weapon;

import by.etc.code_review.oop.task04.entity.Treasure;

public class Weapon extends Treasure {

	private int attack;

	public Weapon() {
		this.attack = setRandomParameter();
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void setRandomName() {
		int value = getRandom().nextInt(WeaponType.values().length);
		WeaponType[] types = WeaponType.values();
		setName(types[value].getName());
	}

	@Override
	public int setRandomParameter() {
		return getRandom().nextInt(9) + 1;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t attack %s,\t %d gold", getId(), getName(), attack, getValue());
	}
}
