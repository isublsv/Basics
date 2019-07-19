package by.etc.code_review.oop.task04.entity.artifact;

import by.etc.code_review.oop.task04.entity.Treasure;

public class Artifact extends Treasure {

	private int power;

	public Artifact() {
		this.power = setRandomParameter();
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public void setRandomName() {
		int value = getRandom().nextInt(ArtifactType.values().length);
		ArtifactType[] types = ArtifactType.values();
		setName(types[value].getName());
	}

	@Override
	public int setRandomParameter() {
		return getRandom().nextInt(25) + 5;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s:\t magic %s,\t %d gold", getId(), getName(), power, getValue());
	}
}
