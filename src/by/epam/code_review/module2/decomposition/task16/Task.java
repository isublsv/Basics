package by.epam.code_review.module2.decomposition.task16;

import java.util.Scanner;

/**
 * 16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. Определить также,
 * сколько четных цифр было найдено в сумме. Для решения задачи использовать декомпозицию.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");

			long n = checkValue();

			long sum = getSum(n);
			System.out.println("Sum of numbers with only odd digits in their values:" + sum);

			int counter = getNumberOfOddDigitsInSumNumber(sum);
			System.out.println("The number of even digits in " + sum + " value = " + counter);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberOfOddDigitsInSumNumber(long sum) {

		int digit;
		int counter = 0;

		while (sum > 0) {
			digit = (int) sum % 10;
			if (digit % 2 == 0) {
				counter++;
			}
			sum = sum / 10;
		}

		return counter;
	}

	private static long getSum(long n) {

		long min = (long) Math.pow(10, n - 1);
		long max = (long) Math.pow(10, n);

		long sum = 0;

		for (long i = min; i <= max - 1; i++) {  //find all numbers with only odd digits
			if (isNumberHasOnlyOddDigits(i)) {
				sum += i;
			}
		}

		return sum;
	}

	private static boolean isNumberHasOnlyOddDigits(long i) {

		int digit;

		while (i > 0) {
			digit = (int) i % 10;
			if (digit % 2 == 0) {
				return false;
			}
			i = i / 10;
		}

		return true;
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
