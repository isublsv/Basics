package by.etc.code_review.decomposition.task14;

import java.util.Scanner;

/**
 * 14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная в
 * степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения этой задачи использовать
 * декомпозицию.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter K value:");

			long k = checkValue();

			System.out.println("The Armstrong numbers from 1 to " + k + " are:");
			getArmstrongNumbers(k);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getArmstrongNumbers(long k) {

		for (long i = 1; i <= k; i++) {
			if (calculateNumber(i, getPower(i)) == i) {
				System.out.print(i + " ");
			}
		}
	}

	private static int getPower(long i) {

		int counter = 0;

		while (i > 0) {
			i = i / 10;
			counter++;
		}

		return counter;
	}

	private static long calculateNumber(long i, int power) {

		int powerSum = 0;

		while (i > 0) {
			powerSum += Math.pow(i % 10, power);
			i = i / 10;
		}

		return powerSum;
	}

	private static long getValue() {
		while (!scanner.hasNextLong()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextLong();
	}

	private static long checkValue() {

		long value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The value must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
