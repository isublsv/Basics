package by.etc.code_review.array_sort.task01;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Заданы два одномерных массива с различным количеством элементов и натуральное число K. Объединить их в один
 * массив, включив второй массив между k-м и (k+1)-м элементами первого, при этом не используя дополнительный массив.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N of the first array:");
			int n = checkArrayDimension();

			long[] firstArray = fillArray(n);
			printArray(firstArray);

			System.out.println("Please, enter dimension M of the second array:");
			int m = checkArrayDimension();

			long[] secondArray = fillArray(m);
			printArray(secondArray);

			System.out.println("Please, enter K value:");
			int k = checkKeyValue(n);

			System.out.println("Combinations of arrays:");
			long[] combineArrays = combineArrays(firstArray, secondArray, k);
			printArray(combineArrays);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[] combineArrays(long[] firstArray, long[] secondArray, int key) {

		long[] newArray = new long[firstArray.length + secondArray.length];

		int secondArrayIndex = 0;
		for (int i = 0; i < newArray.length; i++) {

			if (i < key) {
				newArray[i] = firstArray[i];
			} else if (i >= key && i < key + secondArray.length) {
				newArray[i] = secondArray[secondArrayIndex++];
			} else {
				newArray[i] = firstArray[key++];
			}
		}

		return newArray;
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

	private static int checkArrayDimension() {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0) break;
			else System.out.println("The N must be greater than zero! Enter again: ");
		}

		return value;
	}

	private static int checkKeyValue(int n) {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value <= n) break;
			else System.out.println("The K must be greater than zero and less than N! Enter again: ");
		}

		return value;
	}
}
