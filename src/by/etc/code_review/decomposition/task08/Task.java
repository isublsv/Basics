package by.etc.code_review.decomposition.task08;

import java.util.Random;
import java.util.Scanner;

/**
 * 8. Задан массив D. Определить суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] + D[5] + D[6]. Пояснение. Составить
 * метод (методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");
			int n = checkValue();

			long[] array = fillArray(n);
			printArray(array);

			System.out.println("Please, enter K (the value must be >= 0 and < N - 2): ");
			int k = checkStartIndex(n);

			System.out.println("Please, enter M (the value must be >= K and < N): ");
			int m = checkEndIndex(n, k);

			getSumsInRange(array, k, m);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getSumsInRange(long[] array, int startIndex, int endIndex) {

		long sum = 0;

		Random r = new Random();
		int randomStart;        //random start position between the start and the end indexes,
								// but less than (array.length - 3) value
		do {
			randomStart = r.nextInt((endIndex - startIndex) + 1) + startIndex;
		} while (randomStart < startIndex || randomStart > array.length - 3);

		for (int i = randomStart; i <= randomStart + 2; i++) {
			sum += array[i];
		}
		System.out.println("Sum of three elements of the array between " + randomStart + " and " + (randomStart + 2) + " =" + sum);
	}


	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L;
		}

		return array;
	}

	private static void printArray(long[] array) {

		for (long value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
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

			if (value > 3) {
				break;
			} else {
				System.out.println("The value must be greater than 3! Enter again: ");
			}
		}

		return value;
	}

	private static int checkStartIndex(int n) {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value < n - 2) {
				break;
			} else {
				System.out.println("Wrong value! Enter again: ");
			}
		}

		return value;
	}

	private static int checkEndIndex(int n, int k) {

		int value;

		while (true) {
			value = getValue();
			if (value >= k && value < n) {
				break;
			} else {
				System.out.println("Wrong value! Enter again: ");
			}
		}

		return value;
	}
}
