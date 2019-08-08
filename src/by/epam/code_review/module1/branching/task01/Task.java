package by.epam.code_review.module1.branching.task01;

import java.util.Scanner;

/**
 * 1. Даны два угла треугольника(в градусах). Опеределить, существует ли такой треугольник, и если да,
 * то будет ли он прямоугольным.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter two values of angles x and y in degrees:");

			long x = getValue();
			long y = getValue();

			isTriangle(x, y);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void isTriangle(long x, long y) {
		long sum = x + y;
		if (sum > 0 && sum < 180) {
			System.out.println("The triangle is exist.");
			if ((180 - sum) == 90) {
				System.out.println("The triangle is right-angled.");
			}
		} else {
			System.out.println("The triangle is not exist.");
		}
	}

	private static long getValue() {
		while (!scanner.hasNextLong()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextLong();
	}
}
