package by.epam.code_review.module2.decomposition.task11;

import java.util.Scanner;

/**
 * 11. Написать метод (методы), определющий, в каком из заданных двух чисел больше цифр.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a and b values:");

			long a = getValue();
			long b = getValue();

			getNumberWithMaxUniqueDigits(a, b);
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

	private static void getNumberWithMaxUniqueDigits(long a, long b) {

		int digit = 0;

		long[] arrA = getArr(a);
		long[] arrB = getArr(b);

		int counterA = 0;       //counter for unique digits in the first number A
		int counterB = 0;       //counter for unique digits in the second number B

		while (digit <= 9) {

			for (int i = 0; i < arrA.length; i++) {
				if (arrA[i] == digit) {
					counterA++;
					break;
				}
			}

			for (int j = 0; j < arrB.length; j++) {
				if (arrB[j] == digit) {
					counterB++;
					break;
				}
			}

			digit++;
		}

		if (counterA > counterB) {
			System.out.println("The number " + a + " has more unique digits");
		} else if (counterA < counterB) {
			System.out.println("The number " + b + " has more unique digits");
		} else {
			System.out.println("The number " + a + " and " + b + " has the same amount of unique digits");
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
