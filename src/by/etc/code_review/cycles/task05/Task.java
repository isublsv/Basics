package by.etc.code_review.cycles.task05;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * 5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен заданному е.
 * Общий член ряда имеет вид:
 * an = 1 / 2^n + 1 / 3^n;
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter e value:");

			double e = getValue();

			System.out.println("Please, enter n value:");

			double n = checkValue();

			System.out.println("The sum of series: " + getSumOfSeries(e, n));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double getSumOfSeries(double e, double n) {
		double sum = 0;

		for (int i = 0; i < n; i++) {

			double v = (1 / pow(2, i)) + (1 / pow(3, i));

			if (abs(v) >= e) {
				sum += v;
			}
		}

		return sum;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}

	private static double checkValue() {
		double value;

		while (true) {
			value = getValue();

			if (value > 0) break;
			else System.out.println("The n must be greater than zero! Enter again: ");
		}

		return value;
	}
}
