package by.etc.code_review.oop.task05;

import by.etc.code_review.oop.task05.utils.BouquetUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The simple menu.
 */

public class Menu {

	private static Scanner scanner = new Scanner(System.in);

	public void run() {

		try {
			System.out.println("Please, enter the name of flower composition:");
			String name = getName();

			System.out.println("Please, choose the producing country (Holland or Belarus):");
			String producer = getProducer();

			System.out.println("Please, enter the number of flowers you want:");
			int numberOfFlowers = checkValue();

			System.out.println("Please, enter the number of wraps you want:");
			int numberOfWraps = checkValue();

			BouquetUtils bouquet = new BouquetUtils(name, producer, numberOfFlowers, numberOfWraps);
			bouquet.printBouquet();

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private String getName() {
		Pattern pattern = Pattern.compile("[\\w ]{10,}");
		scanner.useDelimiter("[\r\n]");
		while (!scanner.hasNext(pattern)) {
			scanner.nextLine();
			System.out.println("The name must contains more than 10 letters! Enter again:");
		}

		return scanner.nextLine();
	}

	private String getProducer() {
		Pattern pattern = Pattern.compile("(Holland)|(Belarus)");
		while (!scanner.hasNext(pattern)) {
			scanner.nextLine();
			System.out.println("Enter \"Holland\" or \"Belarus\":");
		}

		return scanner.nextLine();
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

			if (value > 0) {
				break;
			} else {
				System.out.println("Wrong value! Enter again: ");
			}
		}

		return value;
	}


}

