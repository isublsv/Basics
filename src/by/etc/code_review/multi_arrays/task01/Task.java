package by.etc.code_review.multi_arrays.task01;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkValue();

			System.out.println("Please, enter matrix dimension M:");
			int m = checkValue();

			long[][] matrix = fillMatrix(n, m);
			printMatrix(matrix);

			System.out.println("Odd columns where the first element greater than the last element:");
			printColumns(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void printColumns(long[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j+=2) {            //only odd columns

				long firstElement = matrix[0][j];
				long lastElement = matrix[matrix.length - 1][j];

				if (firstElement > lastElement) {
					System.out.format("%3d\t", matrix[i][j]);
				}
			}

			System.out.println();
		}
	}

	private static long[][] fillMatrix(int n, int m) {

		long[][] matrix = new long[n][m];
		Random r = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = r.nextLong() / 100000000000000000L;
			}
		}

		return matrix;
	}

	private static void printMatrix(long[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.format("%3d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}


	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value > 0) break;
			else System.out.println("The value must be greater than 1! Enter again: ");
		}

		return value;
	}
}
