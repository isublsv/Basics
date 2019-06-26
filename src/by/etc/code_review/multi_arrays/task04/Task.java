package by.etc.code_review.multi_arrays.task04;

import java.util.Scanner;

/**
 * 4. Сформировать квадратную матрицу порядка n по заданному образцу(n-четное):
 * {1  2   3  ... n}
 * {n n-1 n-2 ... 1}
 * {1  2   3  ... n}
 * {n n-1 n-2 ... 1}
 * {. ... ... ... .}
 * {n n-1 n-2 ... 1}
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkValue();

			System.out.println("The matrix view:");
			printMatrix(n);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void printMatrix(int n) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i % 2 == 0){
					matrix[i][j] = j+1;
					System.out.format("%3d\t", matrix[i][j]);
				}else {
					matrix[i][j] = matrix.length - j;
					System.out.format("%3d\t", matrix[i][j]);
				}
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

			if (value > 0 && value % 2 == 0) break;
			else System.out.println("The value must be even and greater than 0! Enter again: ");
		}

		return value;
	}
}
