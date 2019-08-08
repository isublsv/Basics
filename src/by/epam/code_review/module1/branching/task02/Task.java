package by.epam.code_review.module1.branching.task02;

import java.util.Locale;
import java.util.Scanner;

/**
 * 2. Найти max{min(a, b), min(c, d)}
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a, b, c, d:");

			double a = getValue();
			double b = getValue();
			double c = getValue();
			double d = getValue();

			double min1 = getMinNumber(a, b);
			double min2 = getMinNumber(c, d);

			System.out.println(getMaxNumber(min1, min2));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double getMaxNumber(double a, double b) {
		return a > b ? a : b;
	}

	private static double getMinNumber(double a, double b) {
		return a < b ? a : b;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
