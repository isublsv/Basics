package by.epam.code_review.module2.single_array.task02;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 2. Дана последовательность действительных чисел a1, a2 ... a(n). Заменить все ее члены, больше заданного Z, этим числом.
 * Подсчитать количество замен.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			double[] array = fillArray(n);
			printArray(array);

			System.out.println("Please, enter Z value (-100 ~ +100 for results):");
			double z = getValue();

			System.out.println("Count replacement: " + getReplaceCount(array, z));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getReplaceCount(double[] array, double z) {

		int counter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				counter++;
			}
			System.out.print(array[i] + " ");
		}

		System.out.println();

		return counter;
	}

	private static double[] fillArray(int n) {

		double[] array = new double[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextDouble() * 200 - 100;        //random double [-100...100]
		}

		return array;
	}

	private static void printArray(double[] array) {     //for debug

		for (double value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private static double getValue() {

		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextDouble();
	}

	private static int checkValue() {

		int value;

		while (true) {
			value = (int) getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The N must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
