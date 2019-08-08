package by.epam.code_review.module5.oop.task04.entity.weapon;

import by.epam.code_review.module5.oop.task04.entity.Treasure;

public class Weapon extends Treasure {

	private int attack;

	public Weapon() {
		this.attack = getRandomParameter();
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public void setRandomName() {
		int value = random.nextInt(WeaponType.values().length);
		WeaponType[] types = WeaponType.values();
		setName(types[value].getName());
	}

	@Override
	public int getRandomParameter() {
		return random.nextInt(9) + 1;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t attack %s,\t %d gold", getId(), getName(), attack, getValue());
	}
}
