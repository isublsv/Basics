package by.epam.code_review.module5.oop.task04.utils;

import by.epam.code_review.module5.oop.task04.entity.DragonCave;
import by.epam.code_review.module5.oop.task04.entity.Treasure;

import java.util.Collections;

public class DragonCaveUtils {

	private DragonCave dragonCave;

	public DragonCaveUtils(DragonCave dragonCave) {
		this.dragonCave = dragonCave;
	}

	public DragonCave getDragonCave() {
		return dragonCave;
	}

	public void setDragonCave(DragonCave dragonCave) {
		this.dragonCave = dragonCave;
	}

	public void printTreasures(){
		if (dragonCave.getTreasures().isEmpty()){
			System.out.println("The cave is empty!");
			return;
		}

		for (Treasure treasure : dragonCave.getTreasures()){
			System.out.println(treasure);
		}
	}

	public Treasure getTheMostExpensiveTreasure() {
		return Collections.max(dragonCave.getTreasures());
	}

	public int findTreasuresForSum(int sum) {
		if (sum < 0){
			System.out.println("The sum is too low!");
			return 0;
		}

		for (Treasure treasure : dragonCave.getTreasures()){
			if (sum > treasure.getValue()){
				System.out.println(treasure);
				sum -=treasure.getValue();
			}
		}

		return sum;
	}
}
