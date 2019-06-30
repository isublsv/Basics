package by.etc.code_review.cycles.task08;

import java.util.Scanner;

/**
 * 8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a and b values:");

			long a = getValue();
			long b = getValue();

			long[] arrA = getArr(a);
			long[] arrB = getArr(b);

			getSameDigits(arrA, arrB);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[] getArr(long a) {

		int counter = 0;

		a = Math.abs(a);

		long tmp = a;

		while (tmp > 0) {           //find array size
			tmp = tmp / 10;
			counter++;
		}

		long[] array = new long[counter];

		for (int i = array.length - 1; i >= 0; i--) {       //fill the array
			array[i] = a % 10;
			a = a / 10;
		}

		return array;
	}

	private static void getSameDigits(long[] a, long[] b) {

		int digit = 0;

		boolean gotCoincidence = false;

		while (digit <= 9) {

			boolean gotDigit = false;       //flag that signals us the digit exists in the first array

			for (int i = 0; i < a.length; i++) {
				if (a[i] == digit) {
					gotDigit = true;
					break;
				}
			}

			for (int j = 0; j < b.length; j++) {
				if (b[j] == digit && gotDigit) {
					System.out.print(digit + " ");
					gotCoincidence = true;
					break;
				}
			}

			digit++;
		}

		if (!gotCoincidence) {
			System.out.println("There are no the same digits!");
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
