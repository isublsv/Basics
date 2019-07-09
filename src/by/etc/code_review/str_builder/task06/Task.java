package by.etc.code_review.str_builder.task06;

import java.util.Scanner;

/**
 * 6. Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			//String testString = "aaaa aadadsfaa AAAa saaadsf ....a";

			String testString = scanner.nextLine();

			String str = getStrWithDoubleSymbols(testString);

			System.out.println(str);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static String getStrWithDoubleSymbols(String testString) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		StringBuilder sb = new StringBuilder();
		char current;

		for (int i = 0; i < testString.length(); i++) {
			current = testString.charAt(i);
			sb.append(current).append(current);
		}

		return sb.toString();
	}
}
