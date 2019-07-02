package by.etc.code_review.multi_arrays.task09;

import java.util.Random;
import java.util.Scanner;

/**
 * 9. Задана матрица неотрецательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой столбец
 * содержит максимальную сумму.
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

			getColumnsWithMaxSumOfElements(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getColumnsWithMaxSumOfElements(long[][] matrix) {

		long maxSum = 0;
		int index = 0;

		for (int i = 0; i < matrix[0].length; i++) {
			int currentSum = 0;
			for (int j = 0; j < matrix.length; j++) {
				currentSum += matrix[j][i];
			}
			System.out.format("%3d\t", currentSum);
			if (maxSum < currentSum) {
				maxSum = currentSum;
				index = i;
			}
		}

		System.out.println("\n" + index + " column has max sum = " + maxSum);
	}

	private static long[][] fillMatrix(int n, int m) {

		long[][] matrix = new long[n][m];
		Random r = new Random();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.abs(r.nextLong()) / 100000000000000000L;
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
