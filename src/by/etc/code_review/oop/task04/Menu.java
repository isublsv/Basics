package by.etc.code_review.oop.task04;

import by.etc.code_review.oop.task04.entity.DragonCave;
import by.etc.code_review.oop.task04.entity.Treasure;

import java.util.Scanner;

public class Menu {

	private DragonCave dragonCave = new DragonCave();
	private static Scanner scanner = new Scanner(System.in);

	public void run() {

		try {
			while (true) {
				System.out.println("Please, choose an option:");
				System.out.println("1 - Print all treasures in the cave.");
				System.out.println("2 - Find the most expensive treasure.");
				System.out.println("3 - Print treasures for a given sum.");
				System.out.println("0 - Exit.");

				int i = checkValue();

				if (i == 1) {

					System.out.println("The treasures in the cave:");
					dragonCave.printTreasures();

				} else if (i == 2) {

					Treasure treasure = dragonCave.getTheMostExpensiveTreasure();
					System.out.println("The most expensive treasure is " + treasure);

				} else if (i == 3) {

					System.out.println("Please, enter the sum:");
					int sum = getValue();
					int rest = dragonCave.findTreasuresForSum(sum);

					System.out.println("Rest of sum = " + rest + " gold.");

				} else if (i == 0) {
					break;
				}
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value <= 3) {
				break;
			} else {
				System.out.println("Wrong value! Enter again: ");
			}
		}

		return value;
	}
}

