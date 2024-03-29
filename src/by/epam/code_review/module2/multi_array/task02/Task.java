package by.epam.code_review.module2.multi_array.task02;

import java.util.Random;
import java.util.Scanner;

/**
 * 2. Дана квадратная матрица. Вывести на экран элементы стоящие по диагонали.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkValue();

			long[][] matrix = fillMatrix(n);
			printMatrix(matrix);

			System.out.println("Diagonals are:");
			printDiagonals(matrix);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void printDiagonals(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.format("%3d\t", matrix[i][i]);        //print the first diagonal
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.format("%3d\t", matrix[i][matrix[i].length - i - 1]);      //print the second diagonal
		}
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

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value > 0) {
				break;
			} else {
				System.out.println("The N must be greater than 1! Enter again: ");
			}
		}

		return value;
	}
}
