package by.etc.code_review.branching.task05;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * 5. Вычислить значение функции:
 *       {x^2 - 3x + 9, если x <= 3
 * F(x)= {
 *       {1 / (x^3 + 6), если x > 3
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter x value:");

			double x = getValue();

			System.out.println("F(" + x + ")= " + calculateFunction(x));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double calculateFunction(double x) {
		if (x <= 3) {
			return pow(x, 2) - 3 * x + 9;
		} else return 1 / (pow(x, 3) + 6);
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
