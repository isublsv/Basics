package by.epam.code_review.module2.array_sort.task06;

import java.util.Random;
import java.util.Scanner;

/**
 * 6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. Делается это
 * следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai <= ai+1, то продвигаются на один элемент
 * вперед. Если ai > ai+1, то проивзодится перестановка и сдвигаются на один элемент назад. Составить алгоритм этой
 * сортировки.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N:");
			int n = checkArrayDimension();

			double[] array = fillArray(n);
			printArray(array);

			sort(array);

			System.out.println("Sorted array:");
			printArray(array);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void sort(double[] array) {
		int i = 0;
		while (i < array.length - 1) {
			if (array[i] <= array[i + 1]){
				i++;
			}else {
				swap(array, i, i + 1);
				if (i > 1){
					i--;
				} else {
					i = 0;
				}
			}
		}
	}

	private static void swap(double[] array, int i, int j) {
		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static double[] fillArray(int n) {

		double[] array = new double[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextDouble() * 200 - 100;
		}

		return array;
	}

	private static void printArray(double[] array) {

		for (double value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private static int getValue() {

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Enter again:");
		}

		return scanner.nextInt();
	}

	private static int checkArrayDimension() {

		int value;

		while (true) {
			value = getValue();

			if (value >= 0) {
				break;
			} else {
				System.out.println("The N must be greater than zero! Enter again: ");
			}
		}

		return value;
	}
}
