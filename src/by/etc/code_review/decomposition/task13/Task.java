package by.etc.code_review.decomposition.task13;

import java.util.Scanner;

/**
 * 13. Два просты числа называются близнецами, если они отличаются друг от друга на 2 (например, 41 и 43). Найти и
 * напечатать все пары близнецов из отрезка [n, 2n], где n - заданное натуральное число больше 2. Для решения задачи
 * использовать декомпозицию.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");

			long n = checkValue();

			getTwins(n);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getTwins(long n) {

		for (long i = n; i < 2 * n; i++) {
			long next = i + 2;
			if (isPrime(i) && isPrime(next)) {
				System.out.println(i + " " + next);
			}
		}
	}

	private static boolean isPrime(long i) {

		for (int j = 2; j < i; j++) {
			if (i % j == 0) {
				return false;
			}
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

			if (value > 2) {
				break;
			} else {
				System.out.println("The value must be greater than 2! Enter again: ");
			}
		}

		return value;
	}
}
