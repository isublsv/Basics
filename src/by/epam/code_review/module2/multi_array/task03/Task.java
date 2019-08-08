package by.epam.code_review.module2.multi_array.task03;

import java.util.Random;
import java.util.Scanner;

/**
 * 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkMatrixDimensions();

			System.out.println("Please, enter matrix dimension M:");
			int m = checkMatrixDimensions();

			long[][] matrix = fillMatrix(n, m);
			printMatrix(matrix);

			System.out.println("Please, enter string index K:");
			int k = checkIndex(n);

			System.out.println("K-string of matrix:");
			printString(matrix, k);

			System.out.println("\nPlease, enter column index P:");
			int p = checkIndex(m);

			System.out.println("P-column of matrix:");
			printColumn(matrix, p);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void printString(long[][] matrix, int k) {

		for (int i = 0; i < matrix[k].length; i++) {
			System.out.format("%3d\t", matrix[k][i]);
		}

	}

	private static void printColumn(long[][] matrix, int p) {

		for (int i = 0; i < matrix.length; i++) {
			System.out.format("%3d\n", matrix[i][p]);
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

	private static int checkIndex(int n) {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value < n) {
				break;
			} else System.out.println("Wrong index! Enter again: ");
		}

		return value;
	}

	private static int checkMatrixDimensions() {

		int value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The value must be >= 0! Enter again: ");
			}
		}

		return value;
	}
}
