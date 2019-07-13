package by.etc.code_review.line_programs.task02;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * b + sqrt(b^2 + 4ac)/2a - a^3c + b^-2.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a, b, c:");

			double a = getValue();
			double b = getValue();
			double c = getValue();

			System.out.println("z = " + calculateExpression(a, b, c));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double calculateExpression(double a, double b, double c) {
		double sqrt = sqrt(pow(b, 2) + 4 * a * c);
		return (b + sqrt) / (2 * a) - pow(a, 3) * c + pow(b, -2);
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
