package by.etc.code_review.single_arrays.task08;

import java.util.Random;
import java.util.Scanner;

/**
 * 8. Дана последовательность целых чисел a1, a2, ..., a(n). Образовать новую последовательность, выбросив из исходной
 * те члены, которые равны min(a1, a2, ..., a(n)).
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter array dimension N:");

			int n = checkValue();

			long[] array = fillArray(n);

			System.out.println("New array without min element: ");

			long[] resultArray = getNewArrayWithoutMinElement(array);

			//long[] arr = {-5, -5, 0, 10, 22, -5};
			//long[] resultArray1 = getNewArrayWithoutMinElement(arr);
			//printArray(resultArray1);

			printArray(resultArray);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static long[] fillArray(int n) {

		long[] array = new long[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextLong() / 100000000000000000L; // (for debug);
			System.out.print(array[i] + " ");
		}

		System.out.println();
		return array;
	}


	private static long[] getNewArrayWithoutMinElement(long[] array) {

		long minValue = array[0];       //min element
		int counter = 0;        //number of min elements

		for (int i = 0; i < array.length; i++) {
			if (minValue > array[i]) {
				minValue = array[i];
				counter = 1;
			} else if (minValue == array[i]) {
				counter++;
			}
		}

		long[] newArray = new long[array.length - counter];

		int j = 0;      //index for new array

		for (int i = 0; i < array.length; i++) {
			if (array[i] != minValue) {
				newArray[j] = array[i];
				j++;
			}
		}

		return newArray;
	}

	private static void printArray(long[] array){
		for (long anArray : array) {
			System.out.print(anArray + " ");
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

			if (value > 0) break;
			else System.out.println("The N must be greater than zero! Enter again: ");
		}

		return value;
	}
}
