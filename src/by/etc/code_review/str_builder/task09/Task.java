package by.etc.code_review.str_builder.task09;

import java.util.Scanner;

/**
 * 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только
 * английские буквы.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();

			getLongestWord(testString);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getLongestWord(String testString) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return;
		}

		int upperCaseCounter = 0;
		int lowerCaseCounter = 0;

		char current;

		for (int i = 0; i < testString.length(); i++) {

			current = testString.charAt(i);

			if (Character.isUpperCase(current)) {
				upperCaseCounter++;
			} else if (Character.isLowerCase(current)) {
				lowerCaseCounter++;
			}
		}

		System.out.println("The test string has " + upperCaseCounter + " characters in upper case and "
				+ lowerCaseCounter + " characters in lower case.");
	}
}
