package by.etc.code_review.str_array.task03;

import java.util.Scanner;

/**
 * 3. В строке найти количество цифр.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();
			//String testString = "For example, 3.14 = 03.14 = 003.14.";


			int number = getNumberOfDigits(testString);

			System.out.println("The number of digits in the string = " + number);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberOfDigits(String testString) {

		int counter = 0;

		char[] chars = testString.toCharArray();

		for (char i = '0'; i <= '9'; i++) {
			for (char current : chars) {
				if (i == current) {
					counter++;
				}
			}
		}

		return counter;
	}
}
