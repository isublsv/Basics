package by.epam.code_review.module2.multi_array.task08;

import java.util.Random;
import java.util.Scanner;

/**
 * 8. В числовой матрице поменять местами два любых столбца, т. е. все элементы одного столбца поставить на
 * соответствующие им позиции другого, а элементы второго переместить в первый. Номера столбцов вводит пользователь с
 * клавиатуры.
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

			System.out.println("Please, enter column index K which you want to move to P position:");
			int p = checkColumnIndex(m);

			System.out.println("Please, enter column index P which you want to move to K position:");
			int k = checkColumnIndex(m);

			swapColumns(matrix, p, k);
			printMatrix(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void swapColumns(long[][] matrix, int p, int k) {

		if (p == k) {
			System.out.println("There is no need any changes!");
			return;
		}

		for (int i = 0; i < matrix.length; i++) {
			long temp = matrix[i][p];
			matrix[i][p] = matrix[i][k];
			matrix[i][k] = temp;
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

	private static int checkColumnIndex(int m) {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0 && value < m) {
				break;
			} else {
				System.out.println("The column index must be >= 0 and < M! Enter again: ");
			}
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
