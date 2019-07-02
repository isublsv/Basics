package by.etc.code_review.str_builder.task01;

import java.util.Scanner;

/**
 * 1. Дан текст(строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			/*String testString = "Lorem     ipsum dolor   sit amet, mea    eripuit intellegat cu, vix ne   regione       imperdiet consequat.   ";*/

			String testString = scanner.nextLine();

			System.out.println(testString);

			int maxSpaceNumber = getMaxSpaceNumber(testString);

			System.out.println("The max number of spaces in the test string = " + maxSpaceNumber);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getMaxSpaceNumber(String testString) {
		int counter = 0;                                       //counter for spaces

		String[] strings = testString.split("\\S");     //remove all symbols and digits from string except spaces

		for (String string : strings) {
			if (string.length() > counter) {
				counter = string.length();
			}
		}
		return counter;
	}
}
