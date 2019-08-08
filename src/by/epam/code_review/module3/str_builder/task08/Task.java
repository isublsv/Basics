package by.epam.code_review.module3.str_builder.task08;

import java.util.Scanner;

/**
 * 8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда
 * самых длинных слов может быть несколько, не обрабатывать.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();

			String str = getLongestWord(testString);

			System.out.println("The longest word in the given string is \"" + str + "\"");

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static String getLongestWord(String testString) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		String[] words = testString.split(" ");

		String longestWord = "";
		int maxLength = 0;

		for (String word : words) {

			if (word.length() > maxLength) {
				maxLength = word.length();
				longestWord = word;
			}
		}

		return longestWord;
	}
}
