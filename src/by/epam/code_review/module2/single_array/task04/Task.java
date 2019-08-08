package by.epam.code_review.module2.single_array.task04;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 4. Даны действительные числа а1, а2, ..., а(n).  Поменять местами наибольший и наименьший элементы.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			double[] array = fillArray(n);
			printArray(array);

			findMinMaxElements(array);
			printArray(array);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void findMinMaxElements(double[] array) {

		int minIndex = 0;       //index of min element in array
		int maxIndex = 0;       //index of max element in array

		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			} else if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		replaceMinMaxElements(array, minIndex, maxIndex);
	}

	private static void replaceMinMaxElements(double[] array, int minIndex, int maxIndex) {

		double swap = array[minIndex];
		array[minIndex] = array[maxIndex];      //replace elements with each other
		array[maxIndex] = swap;

		System.out.println("Min swapped element: " + minIndex);
		System.out.println("Max swapped element: " + maxIndex);
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
