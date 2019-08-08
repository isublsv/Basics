package by.epam.code_review.module1.line_programs.task01;

import java.util.Locale;
import java.util.Scanner;

/**
 * 1. Найдите значение функции: z = ((a - 3) * b / 2) + c.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a, b, c:");

			double a = getValue();
			double b = getValue();
			double c = getValue();

			System.out.println("z = " + calculateNumber(a, b, c));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double calculateNumber(double a, double b, double c) {
		return ((a - 3) * b / 2) + c;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
