package by.etc.code_review.multi_arrays.task12;

import java.util.Random;
import java.util.Scanner;

/**
 * 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
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

			System.out.println("Sort strings in ascending order:");
			sortStrings(matrix, Boolean.TRUE);
			printMatrix(matrix);

			System.out.println("Sort strings in descending order:");
			sortStrings(matrix, Boolean.FALSE);
			printMatrix(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void sortStrings(long[][] matrix, Boolean key) { //O(n^3) in total

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {        //selection sort O(n^2)
				int current = j;
				for (int k = j + 1; k < matrix[i].length; k++) {

					if (key) {
						if (matrix[i][k] < matrix[i][current]) {
							current = k;
						}
					} else {
						if (matrix[i][k] > matrix[i][current]) {
							current = k;
						}
					}

				}

				long tmp = matrix[i][j];      //swap current min or max element depends on key
				matrix[i][j] = matrix[i][current];
				matrix[i][current] = tmp;
			}
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
