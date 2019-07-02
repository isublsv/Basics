package by.etc.code_review.multi_arrays.task10;

import java.util.Random;
import java.util.Scanner;

/**
 * 10. Найти положительные элементы главной диагонали квадратной матрицы.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkMatrixDimensions();

			long[][] matrix = fillMatrix(n);
			printMatrix(matrix);

			getColumnsWithMaxSumOfElements(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getColumnsWithMaxSumOfElements(long[][] matrix) {
		long sum = 0;

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] > 0) {
				sum += matrix[i][i];
			}
		}

		System.out.println("Sum of positive elements of main diagonal = " + sum);
	}

	private static long[][] fillMatrix(int n) {

		long[][] matrix = new long[n][n];
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

	private static int checkMatrixDimensions() {

		int value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The value must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
