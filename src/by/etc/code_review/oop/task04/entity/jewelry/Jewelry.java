package by.etc.code_review.oop.task04.entity.jewelry;

import by.etc.code_review.oop.task04.entity.Treasure;

public class Jewelry extends Treasure {

	private int magic;

	public Jewelry() {
		this.magic = getRandomParameter();
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	@Override
	public void setRandomName() {
		int value = random.nextInt(JewelryType.values().length);
		JewelryType[] types = JewelryType.values();
		setName(types[value].getName());
	}

	@Override
	public int getRandomParameter() {
		return random.nextInt(20) + 1;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t magic %s,\t %d gold", getId(), getName(), magic, getValue());
	}
}
