package by.etc.code_review.decomposition.task10;

import java.util.Scanner;

/**
 * 10. Дано натуральное число N. Написать метод (методы) для формирования массива, элементами которого являются
 * цифры числа N.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");
			long n = checkValue();

			long[] arr = getArr(n);

			System.out.println("The result array: ");
			printArray(arr);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[] getArr(long n) {

		int counter = 0;

		n = Math.abs(n);

		long tmp = n;

		while (tmp > 0) {           //find array size
			tmp = tmp / 10;
			counter++;
		}

		long[] array = new long[counter];

		for (int i = array.length - 1; i >= 0; i--) {       //fill the array
			array[i] = n % 10;
			n = n / 10;
		}

		return array;
	}

	private static void printArray(long[] arr) {
		for (long value : arr) {
			System.out.print(value + " ");
		}
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
