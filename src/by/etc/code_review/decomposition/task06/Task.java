package by.etc.code_review.decomposition.task06;

import java.util.Scanner;

/**
 * 6. Написать метод (методы), проверяющий, являются ли заданные три числа взаимно простыми.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter A value:");
			int a = checkValue();

			System.out.println("Please, enter B value:");
			int b = checkValue();

			System.out.println("Please, enter C value:");
			int c = checkValue();

			boolean prime = isPrimeNumbers(a, b, c);
			System.out.println("Given numbers A, B, C are prime: " + prime);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static boolean isPrimeNumbers(int a, int b, int c) {
		return getNOD(getNOD(a, b), c) == 1;      //if greatest common divisor of numbers is 1 - they are prime
	}

	private static int getNOD(int a, int b) {

		if (a == 0 || b == 0) {
			return 0;
		}

		if (a == b) {
			return a;
		}

		if (a > b) {
			return getNOD(a - b, b);
		}
		return getNOD(a, b - a);
	}

	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The value must be greater than 1! Enter again: ");
			}
		}

		return value;
	}
}
