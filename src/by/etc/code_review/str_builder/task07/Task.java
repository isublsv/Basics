package by.etc.code_review.str_builder.task07;

import java.util.Scanner;

/**
 * 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если введено "abc cde
 * def", то должно быть выведено "abcdef";
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();

			String str = removeDuplicatesAndSpaces(testString);

			System.out.println(str);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static String removeDuplicatesAndSpaces(String testString) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		StringBuilder sb = new StringBuilder();
		String current;     //current symbol

		testString = testString.replaceAll(" ", "");

		for (int i = 0; i < testString.length(); i++) {

			current = Character.toString(testString.charAt(i));

			if (sb.indexOf(current) == -1) {
				sb.append(current);
			}
		}

		return sb.toString();
	}
}
