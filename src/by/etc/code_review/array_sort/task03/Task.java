package by.etc.code_review.array_sort.task03;

import java.util.Random;
import java.util.Scanner;

/**
 * 3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an. Требуется переставить элементы так,
 * чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший элемент и
 * и ставится на первое место, а первый - на место наибольшего. Затем начиная со втрого, это процедура повторяется.
 * Написать алгоритм сортировки выбором.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N of the first array:");
			int n = checkArrayDimension();

			int[] array = fillArrayInAscendingOrder(n);
			printArray(array);

			System.out.println("Selection sort by descending: ");
			sort(array);
			printArray(array);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void sort(int[] array) {

		for (int max = 0; max < array.length - 1; max++) {         //array.length - 1 because of j = max + 13
			int newMax = max;                                     //index of new max element in range (max+1, ... n)
			for (int j = max + 1; j < array.length; j++) {
				if (array[newMax] < array[j]) {
					newMax = j;                                     //found new index of max element
				}
			}

			int temp = array[newMax];       //swap first element with new max element
			array[newMax] = array[max];
			array[max] = temp;
		}
	}

	private static int[] fillArrayInAscendingOrder(int n) {

		int[] array = new int[n];
		Random r = new Random();

		int lastValue = 0;

		for (int i = 0; i < array.length; i++) {
			int currentValue = r.nextInt(200);
			lastValue = lastValue + currentValue;
			array[i] = lastValue;
		}

		return array;
	}

	private static void printArray(int[] array) {

		for (int value : array) {
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
