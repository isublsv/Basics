package by.etc.code_review.cycles.task08;

import java.util.Scanner;

/**
 * 8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a and b values:");

			long a = getValue();
			long b = getValue();

			getSameDigits(a, b);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getSameDigits(long a, long b) {

		String aString = String.valueOf(a);
		String bString = String.valueOf(b);

		for (int i = 0; i < aString.length(); i++) {

			for (int j = 0; j < bString.length(); j++) {

				if (aString.charAt(i) == bString.charAt(j)){

					System.out.print(aString.charAt(i) + " ");

				}
			}
		}
	}

	private static long getValue() {
		while (!scanner.hasNextLong()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextLong();
	}
}
