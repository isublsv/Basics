package by.etc.code_review.oop.task04.entity;

import by.etc.code_review.oop.task04.entity.armor.Armor;
import by.etc.code_review.oop.task04.entity.artifact.Artifact;
import by.etc.code_review.oop.task04.entity.jewelry.Jewelry;
import by.etc.code_review.oop.task04.entity.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DragonCave {

	private static final int N = 100;
	private List<Treasure> treasures;

	public DragonCave() {
		treasures = fillTreasures();
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	private List<Treasure> fillTreasures() {

		List<Treasure> treasureList = new ArrayList<>();

		Random random = new Random();

		for (int i = 0; i < N; i++) {
			int n = random.nextInt(4) + 1;
			Treasure treasure = createTreasure(n);
			treasure.setRandomName();
			treasure.setRandomValue();
			treasureList.add(treasure);
		}
		return treasureList;
	}

	private Treasure createTreasure(int random) {
		switch (random) {
			case 1:
				return new Armor();
			case 2:
				return new Weapon();
			case 3:
				return new Artifact();
			case 4:
				return new Jewelry();
			default:
				throw new IllegalArgumentException("Wrong argument: " + String.valueOf(random));
		}
	}
}
