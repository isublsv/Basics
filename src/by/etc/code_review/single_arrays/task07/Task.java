package by.etc.code_review.single_arrays.task07;

import java.util.Random;
import java.util.Scanner;

/**
 * 7. Даны действительные числа a1, a2, ..., a(n). Найти max(a1 + a(2n), a2 + a(2n-1), ..., a(n) + a(n+1)).
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			long[] array = fillArray(2 * n);
			printArray(array);

			System.out.println("Max sum of pairs of elements = " + getMaxSumOfPair(array));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getMaxSumOfPair(long[] array) {

		int start = 0;
		int end = array.length - 1;

		long maxSum = array[start] + array[end];

		while (array[start++] < array[end--]) {
			long currentSum = array[start] + array[end];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}

		return maxSum;
	}

	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L; // (for debug);
		}

		return array;
	}

	private static void printArray(long[] array) {     //for debug

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

			if (value > 0) break;
			else System.out.println("The N must be greater than zero! Enter again: ");
		}

		return value;
	}
}
