package by.etc.code_review.cycles.task07;

import java.util.Scanner;

/**
 * 7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме еденицы и самого числа.
 * m и n вводятся с клавиатуры.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter m and n values:");

			long m = checkValue();
			long n = checkValue();

			getDividers(m, n);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getDividers(long m, long n) {
		if (m < n) {
			printDividers(m, n);
		} else {
			printDividers(n, m);
		}
	}

	private static void printDividers(long m, long n) {
		for (long i = m; i <= n; i++) {
			int counter = 0;        //counter for numbers without dividers
			System.out.print("The number " + i + " has next dividers: ");
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					System.out.print(j + " ");
					counter++;
				}
			}
			if (counter == 0){
				System.out.print("empty");
			}
			System.out.println();
		}
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
			else System.out.println("The numbers must be greater than zero! Enter again: ");
		}

		return value;
	}
}
