package by.etc.code_review.single_arrays.task03;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, положительных и
 * нулевых элементов.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			double[] array = fillArray(n);
			printArray(array);

			int[] counters = getCounterValues(array);

			System.out.println("Zero elements: " + counters[0]);
			System.out.println("Positive elements: " + counters[1]);
			System.out.println("Negative elements: " + counters[2]);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int[] getCounterValues(double[] array) {

		int positiveCounter = 0;
		int zeroCounter = 0;
		int negativeCounter = 0;

		for (double value : array) {
			if (value > 0) {
				positiveCounter++;
			} else if (value == 0) {
				zeroCounter++;
			} else {
				negativeCounter++;
			}
		}

		return new int[]{zeroCounter, positiveCounter, negativeCounter};
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
