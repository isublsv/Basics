package by.etc.code_review.decomposition.task15;

import java.util.Scanner;

/**
 * 15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например,
 * 1234, 5789). Для решения задачи использовать декомпозицию.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");

			long n = checkValue();

			System.out.println("All numbers with digits that are in the ascending order:");
			getAscNumbers(n);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getAscNumbers(long n) {

		long min = (long) Math.pow(10, n - 1);
		long max = (long) Math.pow(10, n);

		for (long i = min; i <= max - 1; i++) {  //find all numbers with ascending order of their digits
			if (isDesiredNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}

	private static boolean isDesiredNumber(long i) {

		int digit = (int) i % 10;       //get the first digit in the given number
		i = i / 10;

		int current;                    //current digit

		while (i > 0) {
			current = (int) i % 10;
			i = i / 10;
			if (digit <= current) {      //if the nextPage digit greater than or equal the nextPage -  return false;
				return false;
			}
			digit = current;
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
