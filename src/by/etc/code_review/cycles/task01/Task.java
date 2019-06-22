package by.etc.code_review.cycles.task01;

import java.util.Scanner;

/**
 * 1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует все числа от 1
 * до введенного числа.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the number:");

			long number = checkValue();

			System.out.println(getSum(number));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long getSum(long number) {
		long sum = 0;

		for (int i = 1; i <= number; i++) {
			sum += i;
		}

		return sum;
	}

	private static long getValue() {
		while (!scanner.hasNextLong()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextLong();
	}

	private static long checkValue(){
		long value;

		while (true) {
			value = getValue();

			if (value > 0) break;
			else System.out.println("The number must be greater than zero! Enter again: ");
		}

		return value;
	}
}
