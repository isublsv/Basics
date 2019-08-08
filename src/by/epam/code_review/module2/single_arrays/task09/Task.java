package by.epam.code_review.module2.single_arrays.task09;

import java.util.Random;
import java.util.Scanner;

/**
 * 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких чисел
 * несколько, то определить наименьшее из них.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			long[] array = fillArray(n);
			printArray(array);

			System.out.print("Min element with max frequency = ");
			System.out.println(getMaxFrequencyMinElement(array));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getMaxFrequencyMinElement(long[] array) {
		int[] freq = new int[array.length];     //array contains frequency of each element of the given array

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					freq[i]++;
				}
			}
		}

		long minElement = array[0];         //min element of the given array with max frequency
		int maxFreq = freq[0];              //max frequency

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > maxFreq) {        //find max frequency
				maxFreq = freq[i];
				minElement = array[i];
			}

			if (maxFreq == freq[i] && array[i] < minElement) {      //if exists another element with the same frequency
				minElement = array[i];                              //compare them
			}
		}

		return minElement;
	}

	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L; // (for debug);
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

			if (value > 0) {
				break;
			} else {
				System.out.println("The N must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
