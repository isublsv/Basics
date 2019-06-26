package by.etc.code_review.single_arrays.task06;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются
 * простыми числами.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			double[] array = fillArray(n);
			printArray(array);

			System.out.println("Sum elements with prime number indexes = " + getSumElementsWithPrimeIndex(array));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double getSumElementsWithPrimeIndex(double[] array) {

		double sum = 0;

		for (int i = 2; i < array.length; i++) {
			if (isPrime(i)){
				sum += array[i];
			}
		}
		return sum;
	}

	private static boolean isPrime(int i) {

		for (int j = 2; j < i; j++) {
			if (i % j == 0){
				return false;
			}
		}
		//System.out.println(i + " is prime number!");
		return true;
	}

	private static double[] fillArray(int n) {

		double[] array = new double[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextDouble() * 200 - 100;        //random double [-100...100]
		}

		return array;
	}

	private static void printArray(double[] array){     //for debug
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

			if (value > 0) break;
			else System.out.println("The N must be greater than zero! Enter again: ");
		}

		return value;
	}
}
