package by.etc.code_review.str_array.task04;

import java.util.Scanner;

/**
 * 4. В строке найти количество чисел.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();
			//String testString = "For example, 3.14 = 03.14 = 003.14. 22 123.23";


			int number = getNumberOfNumbers(testString);

			System.out.println("The number of digits in the string = " + number);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberOfNumbers(String testString) {

		int counter = 0;
		boolean isNumber = false;       //signals that the number is found

		char[] chars = testString.toCharArray();

		for (int i = 0; i < chars.length - 1; i++) {
			if (isDigit(chars[i]) && isDigit(chars[i + 1])) {  //if current char is digit and the next char is '.' or digit
				if (!isNumber) {
					counter++;
					isNumber = true;
				}
			} else {
				isNumber = false;
			}
		}


		return counter;
	}

	private static boolean isDigit(char c) {
		for (int i = '0'; i < '9'; i++) {
			if (c == i || c == '.') {       //'.' is for the decimal numbers
				return true;
			}
		}
		return false;
	}
}
