package by.etc.code_review.decomposition.task05;

import java.util.Random;
import java.util.Scanner;

/**
 * 5. Составить программу, которая в массиве А[N] находит второе по величине число(вывести на печать число, которое
 * меньше максимального элемента массива, но больше всех других элементов).
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");
			int n = checkValue();

			long[] array = fillArray(n);

			printArray(array);

			long secondMaxValue = findSecondMaxValue(array);

			System.out.println("Second max value = " + secondMaxValue);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long findSecondMaxValue(long[] array) {

		long maxValue = Long.MIN_VALUE;
		long secondMaxValue = maxValue;

		for (int i = 0; i < array.length; i++) {
			if (maxValue < array[i]) {
				secondMaxValue = maxValue;
				maxValue = array[i];
			}
		}

		System.out.println("Max value = " + maxValue);
		return secondMaxValue;
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

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
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

			if (value > 0) {
				break;
			} else {
				System.out.println("The value must be greater than 1! Enter again: ");
			}
		}

		return value;
	}
}
