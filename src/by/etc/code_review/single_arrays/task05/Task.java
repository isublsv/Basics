package by.etc.code_review.single_arrays.task05;

import java.util.Random;
import java.util.Scanner;

/**
 * 5. Даны целые числа а1, а2, ..., а(n). Вывести на печать только те числа, для которых а[i] > i.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			long[] array = fillArray(n);
			printArray(array);

			System.out.println("Number which are а[i] > i: ");
			printNumbers(array);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}


	private static void printNumbers(long[] a) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] > i) {
				System.out.format("a[i]=%d \ti=%d\n", a[i], i);
			}
		}
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
