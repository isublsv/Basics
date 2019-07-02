package by.etc.code_review.decomposition.task17;

import java.util.Scanner;

/**
 * 17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т. д. Сколько таких действий
 * гадо произвести, чтобы получился нуль. Для решения задачи использовать декомпозию.
 */

public class Task {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");

			long n = checkValue();

			long sum = getNumberOfActions(n);
			System.out.println("The number of actions = " + sum);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getSumOfDigits(long number) {

		long sum = 0;

		while (number > 0) {
			sum += number % 10;
			number = number / 10;
		}

		return sum;
	}

	private static long getNumberOfActions(long n) {

		int counter = 0;

		while (n != 0) {
			n -= getSumOfDigits(n);
			counter++;
		}

		return counter;
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
