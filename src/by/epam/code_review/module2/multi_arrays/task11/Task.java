package by.epam.code_review.module2.multi_arrays.task11;

import java.util.Random;

/**
 * 11. Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в которых
 * число 5 встречается три и более раз.
 */
public class Task {

	public static void main(String[] args) {

		System.out.println("Matrix:");
		int[][] matrix = fillMatrix();
		printMatrix(matrix);

		System.out.println("Strings in which element 5 occurs more than 3 times: ");
		getStrings(matrix);
	}

	private static void getStrings(int[][] matrix) {

		int counter = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == 5) {
					counter++;
				}
			}

			if (counter >= 3) {
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.format("%3d\t", matrix[i][j]);
				}
				System.out.println();
			}
			counter = 0;
		}
	}

	private static int[][] fillMatrix() {

		int[][] matrix = new int[10][20];
		Random r = new Random();
		int max = 15;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = r.nextInt(max + 1);
			}
		}

		return matrix;
	}

	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.format("%3d\t", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
