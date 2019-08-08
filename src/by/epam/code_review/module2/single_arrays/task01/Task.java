package by.epam.code_review.module2.single_arrays.task01;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. В массив А[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = (int) checkValue();

			long[] array = fillArray(n);
			printArray(array);

			System.out.println("Please, enter K value:");
			long k = getValue();

			System.out.println("Sum of numbers which are multiples of K: " + getSum(array, k));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getSum(long[] a, long k) {

		long sum = 0;

		for (long value : a) {
			if (value % k == 0) {
				sum += value;
			}
		}

		return sum;
	}

	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L;
		}

		return array;
	}

	private static void printArray(long[] array) {     //for debug

		for (long value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
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
				System.out.println("The N must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
