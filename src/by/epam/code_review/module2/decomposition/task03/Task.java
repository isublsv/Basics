package by.epam.code_review.module2.decomposition.task03;

import java.util.Scanner;

/**
 * 3. Вычислить площадь правильного шестиугольника со стороной A, используя метод вычисления площади треугольника.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter A value:");
			int a = checkValue();

			double square = getHexagonSquare(a);
			System.out.println("Hexagon square = " + square);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double getHexagonSquare(int a) {
		return 6 * getTriangleSquare(a);
	}

	private static double getTriangleSquare(int a) {
		return Math.sqrt(3) / 4 * a * a;
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
