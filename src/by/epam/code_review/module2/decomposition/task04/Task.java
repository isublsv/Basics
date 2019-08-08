package by.epam.code_review.module2.decomposition.task04;

import java.util.Random;
import java.util.Scanner;

/**
 * 4. На плоскости заданы своими координатами n точек. Написать метод (методы), определяющие, между какими из пар точек
 * самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter N value:");
			int n = checkValue();

			long[][] points = fillArray(n);
			long[][] mockArr = {{1, 1}, {1, 2}, {3, 1}, {3, 2}};

			printArray(points);
			System.out.println("========================");
			printArray(mockArr);

			long[][] maxDistPoints = findMaxDistPoints(points);
			long[][] maxDistPoints1 = findMaxDistPoints(mockArr);

			System.out.println("The max distance is between the next points:");
			printArray(maxDistPoints);
			System.out.println("========================");
			printArray(maxDistPoints1);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[][] findMaxDistPoints(long[][] points) {

		double maxDist = 0;
		long[][] maxDistPoints = new long[2][2];

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double currentDist = findDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
				if (currentDist > maxDist) {
					maxDist = currentDist;
					maxDistPoints = savePairOfPoints(points[i][0], points[i][1], points[j][0], points[j][1]);
				} else if (currentDist == maxDist) {        //if we got another pair of points with max distance
					maxDistPoints = addPairOfPoints(maxDistPoints, points[i][0], points[i][1], points[j][0], points[j][1]);
				}
			}
		}
		return maxDistPoints;
	}

	private static long[][] addPairOfPoints(long[][] arr, long x1, long y1, long x2, long y2) {
		long[][] points = new long[arr.length + 2][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				points[i][j] = arr[i][j];
			}
		}

		points[arr.length][0] = x1;
		points[arr.length][1] = y1;
		points[arr.length + 1][0] = x2;
		points[arr.length + 1][1] = y2;

		return points;
	}

	private static long[][] savePairOfPoints(long x1, long y1, long x2, long y2) {
		long[][] maxDistPoints = new long[2][2];

		maxDistPoints[0][0] = x1;
		maxDistPoints[0][1] = y1;
		maxDistPoints[1][0] = x2;
		maxDistPoints[1][1] = y2;

		return maxDistPoints;
	}

	private static double findDistance(long x1, long y1, long x2, long y2) {
		double comp1 = Math.pow((x2 - x1), 2);
		double comp2 = Math.pow((y2 - y1), 2);
		return Math.sqrt(comp1 + comp2);
	}

	private static long[][] fillArray(int n) {

		long[][] array = new long[n][2];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.abs(r.nextLong() / 100000000000000000L);
			}
		}

		return array;
	}

	private static void printArray(long[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
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
				System.out.println("The value must be greater than 1! Enter again: ");
			}
		}

		return value;
	}
}
