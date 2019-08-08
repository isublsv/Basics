package by.epam.code_review.module1.branching.task03;

import java.util.Locale;
import java.util.Scanner;

/**
 * 3. Даны три точки A(x1, y1), B(x2, y2) и C(x3, y3). Определить, будут ли они расположены на одной прямой.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the coordinates of A point:");
			double x1 = getValue();
			double y1 = getValue();

			System.out.println("Please, enter the coordinates of B point:");
			double x2 = getValue();
			double y2 = getValue();

			System.out.println("Please, enter the coordinates of C point:");
			double x3 = getValue();
			double y3 = getValue();

			System.out.println("All points are on the same line: " + arePointsOnSameLine(x1, y1, x2, y2, x3, y3));      //(1,2); (2,4); (3,6) - true

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static boolean arePointsOnSameLine(double x1, double y1, double x2, double y2, double x3, double y3) {
		double acc = 1e-20;     //calculation accuracy
		return Math.pow(((x3 - x1) / (x2 - x1) - (y3 - y1) / (y2 - y1)), 2) <= acc;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
