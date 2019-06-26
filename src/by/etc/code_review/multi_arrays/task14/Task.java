package by.etc.code_review.multi_arrays.task14;

import java.util.Scanner;

/**
 * 14. Сформировать случайную матрицу MxN, состоящую из нулей и едениц, причем в каждом столбце число едениц равно
 * номеру столбца.
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

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[][] fillMatrix(int n, int m) {

		long[][] matrix = new long[n][m];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i < j) {
					matrix[i][j] = 1;
				}
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

			if (value > 0) break;
			else System.out.println("The value must be >= 0! Enter again: ");
		}

		return value;
	}
}