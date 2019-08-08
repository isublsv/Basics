package by.epam.code_review.module2.decomposition.task09;

import java.util.Scanner;

/**
 * 9. Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод (методы) вычисления его площади, если угол
 * между сторонами длиной X и Y - прямой.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter X value:");
			int x = checkValue();

			System.out.println("Please, enter Y value:");
			int y = checkValue();

			System.out.println("Please, enter Z value:");
			int z = checkValue();

			double d = getHypotenuse(x, y);

			System.out.println("Please, enter T value:");
			int t = checkIfConvexQuadrangle(d, z);

			double square = getQuadrangleSquare(x, y, z, t, d);
			System.out.println("The quadrangle square: " + square);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double getHypotenuse(int x, int y) {
		return Math.sqrt(x * x + y * y);
	}

	private static double getQuadrangleSquare(int x, int y, int z, int t, double d) {
		return getRectangleSquare(x, y) + getTriangleSquare(d, z, t);
	}

	private static double getTriangleSquare(double d, int z, int t) {
		double p = (z + t + d) / 2;
		return Math.sqrt(p * (p - z) * (p - t) * (p - d));
	}

	private static double getRectangleSquare(int x, int y) {
		return (x * y) / 2;
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

	private static int checkIfConvexQuadrangle(double d, int z) {

		int value;

		double diff = d - z;

		while (true) {
			value = getValue();

			if (value > diff) {
				break;
			} else {
				System.out.println("The value must be greater than " + diff + "! Enter again: ");
			}
		}

		return value;
	}
}
