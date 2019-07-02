package by.etc.code_review.str_builder.task05;

import java.util.Scanner;

/**
 * 5. Подсчитать, сколько раз среди символов заданной строки встречается буква "a".
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			//String testString = "aaaa aadadsfaa AAAa saaadsf ....a";

			String testString = scanner.nextLine();

			char symbol = 'a';

			int counter = getNumberOfSymbols(testString, symbol);

			System.out.println("The number of symbols " + symbol + " in the string = " + counter);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberOfSymbols(String testString, char symbol) {

		int counter = 0;

		for (int i = 0; i < testString.length(); i++) {
			char current = testString.charAt(i);
			if (current == symbol || current == (symbol & 0x5f)) {      // symbol & 0x5f - toUpperCase
				counter++;
			}
		}
		return counter;
	}
}