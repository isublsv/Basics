package by.etc.code_review.str_builder.task02;

import java.util.Scanner;

/**
 * 2. В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			//String testString = "aaaa aadadsfaa AAAa saaadsf ....a";

			String testString = scanner.nextLine();

			System.out.println(testString);

			String what = "a";
			String to = "ab";

			String resultString = replaceAllEntries(testString, what, to);

			System.out.println(resultString);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static String replaceAllEntries(String testString, String what, String to) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return "";
		}

		return testString.replaceAll(what, to);
	}
}
