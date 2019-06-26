package by.etc.code_review.array_sort.task02;

import java.util.Random;
import java.util.Scanner;

/**
 * 2. Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bn. Образовать из них новую
 * последовательность чисел так, чтобы она тоже была неубывающией. Примечание. Дополнительный массив не использовать.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N of the first array:");
			int n = checkArrayDimension();

			int[] firstArray = fillArrayInAscendingOrder(n);
			printArray(firstArray);

			System.out.println("Please, enter dimension M of the second array:");
			int m = checkArrayDimension();

			int[] secondArray = fillArrayInAscendingOrder(m);
			printArray(secondArray);

			System.out.println("Combinations of arrays:");
			int[] combineArrays = combineArrays(firstArray, secondArray);
			printArray(combineArrays);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int[] combineArrays(int[] firstArray, int[] secondArray) {

		int[] newArray = new int[firstArray.length + secondArray.length];

		int i = 0;      //index in first array
		int j = 0;      //index in second array

		int k;          //index in new array

		for (k = 0; k < newArray.length; k++) {
			if (firstArray[i] < secondArray[j]) {       //compare elements of both arrays
				if (i < firstArray.length - 1) {        //if index is not out of bound of first array
					newArray[k] = firstArray[i++];      //store the element of the first array in a new array
				} else {
					break;                              //else exit from the cycle
				}
			} else {
				if (j < secondArray.length - 1) {       //vice versa
					newArray[k] = secondArray[j++];
				} else {
					break;
				}
			}
		}

		while (i < firstArray.length) {                 //if we reached the end of second array in the previous cycle
			newArray[k++] = firstArray[i++];            //than add all remaining elements from the first array to the new one
		}

		while (j < secondArray.length) {                //vice versa
			newArray[k++] = secondArray[j++];
		}

		return newArray;
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

			if (value >= 0) break;
			else System.out.println("The N must be greater than zero! Enter again: ");
		}

		return value;
	}
}
