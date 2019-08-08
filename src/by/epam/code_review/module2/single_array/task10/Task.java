package by.epam.code_review.module2.single_array.task10;

import java.util.Random;
import java.util.Scanner;

/**
 * 10. Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй элемент
 * (освободившиеся элементы заполнить нулями). Примечание. Дополнительный элемент не использовать.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");
			int n = checkValue();

			long[] array = fillArray(n);
			printArray(array);

			System.out.println("The view of given array after compressing: ");
			printArray(compressArray(array));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[] compressArray(long[] array) {

		for (int i = 1; i < array.length; i += 2) {     //set each second element by 0
			array[i] = 0;
		}

		int i = 0;
		int j = i + 1;
		while (j < array.length) {
			if (array[i] == 0) {                //if first element is 0
				if (array[j] != 0) {            //and if the next element is not 0
					array[i] = array[j];        //swap them
					array[j] = 0;               //set the next element by 0
					i++;                        //move first index
				} else if (array[j] == 0) {     //if the next element is 0
					j++;                        //move second index
				}
			} else {
				i++;                            //move first index
			}
		}
		return array;
	}

	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L; // (for debug);
		}

		return array;
	}

	private static void printArray(long[] array) {
		for (long value : array) {
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

	private static int checkValue() {

		int value;

		while (true) {
			value = getValue();

			if (value > 1) {
				break;
			} else {
				System.out.println("The N must be greater than 1! Enter again: ");
			}
		}

		return value;
	}
}
