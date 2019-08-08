package by.epam.code_review.module2.multi_array.task16;

import java.util.Scanner;

/**
 * 16. Магическим квадратом порядка N называется матрица размера NxN, составленная из числе 1, 2, 3, ..., N^2 так,
 * что по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.
 * Пример магического квадрата порядка 3:
 * {6 1 8}
 * {7 5 3}
 * {2 9 4}
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter matrix dimension N:");
			int n = checkValue();
			//int n = 3;

			int[] array = fillArray(n);
			//int[] array = {8, 1, 6, 3, 5, 7, 4, 9, 2};

			getMagicSquares(n, array);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getMagicSquares(int n, int[] array) {

		int magicConst = getMagicConst(n);      //magic constant

		int size = n * n;
		int[] indexes = new int[size];
		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = 0;
		}

		//Heap's algorithm
		int i = 0;
		while (i < size) {
			if (indexes[i] < i) {

				int[][] matrix = fillMatrix(array);         //convert array to matrix

				if (checkSums(matrix, magicConst)) { //check if the matrix is a magic square
					printMagicSquare(matrix);
				}

				swap(array, i % 2 == 0 ? 0 : indexes[i], i);
				indexes[i]++;
				i = 0;
			} else {
				indexes[i] = 0;
				i++;
			}
		}
	}

	private static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private static boolean checkSums(int[][] matrix, int magicConst) {

		return checkRows(matrix, magicConst) && checkColumns(matrix, magicConst) && checkDiagonals(matrix, magicConst);
	}

	private static boolean checkRows(int[][] matrix, int magicConst) {
		int sum = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}

			if (sum != magicConst) {
				return false;
			}
			sum = 0;
		}
		return true;
	}

	private static boolean checkColumns(int[][] matrix, int magicConst) {
		int sum = 0;

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sum += matrix[j][i];
			}

			if (sum != magicConst) {
				return false;
			}
			sum = 0;
		}

		return true;
	}

	private static boolean checkDiagonals(int[][] matrix, int magicConst) {
		int d1 = 0;
		int d2 = 0;

		for (int i = 0; i < matrix.length; i++) {
			d1 += matrix[i][i];
			d2 += matrix[i][matrix.length - i - 1];
		}

		if (d1 != d2) {
			return false;
		}

		return d1 == magicConst;
	}

	private static int getMagicConst(int n) {
		return n * (n * n + 1) / 2;
	}

	private static void printMagicSquare(int[][] magicSquare) {

		for (int i = 0; i < magicSquare.length; i++) {
			for (int j = 0; j < magicSquare[i].length; j++) {
				System.out.format("%3d\t", magicSquare[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int[] fillArray(int n) {

		int[] arr = new int[n * n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		return arr;
	}

	private static int[][] fillMatrix(int[] arr) {

		int size = (int) Math.sqrt(arr.length);
		int arrIndex = 0;

		int[][] matrix = new int[size][size];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = arr[arrIndex++];
			}

		}

		return matrix;
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

			if (value > 2) {
				break;
			} else {
				System.out.println("The value must be greater than 2! Enter again: ");
			}
		}

		return value;
	}
}
