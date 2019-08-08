package by.epam.code_review.module2.decomposition.task12;

import java.util.Scanner;

/**
 * 12. Даны натуральные числа K и N. Написать метод (методы) формирования массива А, элементами которого являются
 * числа, сумма цифр которых равна K и которые не больше N.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter K and N values:");

			long k = checkValue();
			long n = checkValue();

			long[] numbers = getArr(k, n);

			System.out.println("Result array: ");
			printArray(numbers);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getSum(long a) {        //get sum of digits

		a = Math.abs(a);
		long sum = 0;

		while (a > 0) {
			sum += a % 10;
			a = a / 10;
		}

		return sum;
	}

	private static int gerArrayDimension(long k, long n) {
		int index = 0;

		for (int i = 0; i <= n; i++) {       //get result array dimension
			if (getSum(i) == k) {
				index++;
			}
		}
		return index;
	}

	private static long[] getArr(long k, long n) {

		int indexArr = gerArrayDimension(k, n);
		long[] arr = new long[indexArr];

		for (int i = 0, index = 0; i < n; i++) {       //fill array
			if (getSum(i) == k) {
				arr[index] = i;
				index++;
			}
		}

		return arr;
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
