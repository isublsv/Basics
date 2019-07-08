package by.etc.code_review.array_sort.task05;

import java.util.Random;
import java.util.Scanner;

/**
 * 5. Сортировка вставками. Дана последовательность чисел a1, a2, ..., ai. Требуется переставить числа в порядке
 * возрастания. Делается это следующим образом. Пусть a1, a2, ..., ai - упорядоченная последовательность, т. е.
 * a1 <= a2 <= ... <= an. Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
 * последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
 * не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью
 * двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N:");
			int n = checkArrayDimension();

			int[] array = fillArray(n);
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

	private static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {

			int key = array[i];

			int insPos = binarySearch(array, 0, i - 1, key);

			for (int j = i; j > insPos; j--) {
				array[j] = array[j - 1];
			}
			array[insPos] = key;
		}
	}

	private static int binarySearch(int[] array, int low, int high, int key) {
		int middle;

		while (low <= high) {
			middle = high + low / 2;
			if (key > array[middle]) {
				low = middle + 1;
			} else if (key < array[middle]){
				high = middle - 1;
			}else {
				return middle;
			}
		}

		return low;
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
