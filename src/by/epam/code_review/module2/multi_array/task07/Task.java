package by.epam.code_review.module2.multi_array.task07;

import java.util.Scanner;

/**
 * 7. Сформировать квадратную матрицу порядка N по правилу: A[I, J] = sin((I^2 - J^2)/N) и подсчитать количество
 * положительных элементов в ней.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkValue();

			System.out.println("The number of positive elements in the matrix = " + getNumberPositiveElements(n));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int getNumberPositiveElements(int n) {

		double[][] matrix = new double[n][n];
		int counter = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / matrix.length);
				System.out.format("%4f\t", matrix[i][j]);
				if (matrix[i][j] > 0) {
					counter++;
				}
			}
			System.out.println();
		}
		return counter;
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
				System.out.println("The value must be greater than 0! Enter again: ");
			}
		}

		return value;
	}
}
