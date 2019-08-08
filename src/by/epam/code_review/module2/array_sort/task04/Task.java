package by.epam.code_review.module2.array_sort.task04;

import java.util.Random;
import java.util.Scanner;

/**
 * 4. Сортировка обменами. Дана последовательность чисел. Требуется переставить числа в порядке возрастания. Для этого
 * сравниваются два соседних числа ai и ai+1. Если аi > аi+1, то делается перестановка. Так продолжается до тех пор,
 * пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки, подсчитывая при
 * этом количества перестановок.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N:");
			int n = checkArrayDimension();

			int[] array = fillArray(n);
			printArray(array);

			System.out.println("The number of swaps = " + sort(array));
			printArray(array);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int sort(int[] array) {
		int n = array.length;           //
		int counter = 0;                //the number of swaps

		while (n > 0) {
			for (int i = 0; i < array.length - 1; i++) {

				if (array[i] > array[i + 1]) {
					int temp = array[i];                    //swap elements
					array[i] = array[i + 1];
					array[i + 1] = temp;
					counter++;
				}

			}
			//reduce the length of array because max element in the last position and it doesn't need to swap
			n--;
		}
		return counter;
	}

	private static int[] fillArray(int n) {

		int[] array = new int[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(200);
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
