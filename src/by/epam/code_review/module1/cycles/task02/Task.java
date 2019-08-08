package by.epam.code_review.module1.cycles.task02;

import java.util.Locale;
import java.util.Scanner;

/**
 * 2. Вычислить значения функции на отрезке [a, b] с шагом h:
 *      {x, x > 2
 * y =  {
 *      {-x. x <= 2
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter [a, b] values:");

			double a = getValue();
			double b = getValue();

			System.out.println("Please, enter the step value:");

			double step = checkValue();

			System.out.println("Please, enter x value:");

			double x = getValue();

			calculateFunction(a, b, step, x);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void calculateFunction(double a, double b, double step, double x) {
		if (a < b) {
			if (x > 2 || x == 0) {
				printValues(a, b, step, x);
			} else {
				printValues(a, b, step, -x);
			}
		} else {
			if (x > 2 || x == 0) {
				printValues(b, a, step, x);
			} else {
				printValues(b, a, step, -x);
			}
		}
	}

	private static void printValues(double a, double b, double step, double x) {
		for (double i = a; i <= b; i += step) {
			System.out.println("y=" + x);
		}
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}

	private static double checkValue() {
		double value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The step must be greater than zero! Enter again: ");
			}
		}

		return value;
	}
}
