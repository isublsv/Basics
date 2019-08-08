package by.epam.code_review.module2.decomposition.task01;

import java.util.Scanner;

/**
 * 1. Написать метод(методы)для нахождения наибольшего общего делителя и наименьшего общего кратного двух
 * натуральных чисел: (НОК(А, В) = А * В / НОД(А, В))
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter A value:");
			int a = checkValue();

			System.out.println("Please, enter B value:");
			int b = checkValue();

			int nod = getNOD(a, b);
			System.out.println("Greatest common divisor " + a + " and " + b + " = " + nod);

			int nok = getNOK(a, b, nod);
			System.out.println("Least common multiple " + a + " and " + b + " = " + nok);

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

	private static int getNOK(int a, int b, int nod) {

		return a * b / nod;
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
