package by.etc.code_review.line_programs.task05;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * 5. Дано натуральное число T, которое представляет длительность прошедшего времени в секундах. Вывести данное значение
 * длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the number:");

			long number = getValue();

			calculateTime(number);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void calculateTime(long number) {
		long mod = abs(number);
		long hours = mod / 3600; //or number / 3600 % 24 if we need 24H-format time.
		long minutes = (mod % 3600) / 60;
		long seconds = (mod % 3600) % 60;
		System.out.println(hours + "ч " + minutes + "мин " + seconds + "c");
	}

	private static long getValue() {
		while (!scanner.hasNextLong()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextLong();
	}
}
