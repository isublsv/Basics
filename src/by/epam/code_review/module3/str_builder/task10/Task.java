package by.epam.code_review.module3.str_builder.task10;

import java.util.Scanner;

/**
 * 10. Строка состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the string:");

			String testString = scanner.nextLine();
			//String testString = "This is a test. This is a T.L.A. test? The value is 1.192394! The max is 9.";    //4

			int number = getNumberOfSentences(testString);

			System.out.println("The number of sentences in the test string = " + number);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberOfSentences(String testString) {

		if (testString.length() == 0){
			System.out.println("The given string is empty!");
			return 0;
		}

		return testString.split("(?<=[a-z\\d][?.!]\\s)").length;          //[a-z\d]+[.!?]\s+
	}                                                                           //[?!.](?!\d)|(?<!\d)\.
}
