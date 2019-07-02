package by.etc.code_review.decomposition.task02;

import java.util.Scanner;

/**
 * 2. Написать метод (методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
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

			System.out.println("Please, enter D value:");
			int d = checkValue();

			int nod = getNOD(getNOD(a, b), getNOD(c, d));
			System.out.println("Greatest common divisor " + a + ", " + b + ", " + c + ", " + d + " = " + nod);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNOD(int a, int b) {

		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		return a;
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
