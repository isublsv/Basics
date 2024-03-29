package by.epam.code_review.module2.array_sort.task02;

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
			//compare elements of both arrays
			if (firstArray[i] < secondArray[j]) {
				//if index is the last element of first array
				if (i == firstArray.length - 1) {
					//store the element of the first array in a new array
					newArray[k++] = firstArray[i++];
					//exit from the cycle
					break;
				} else {
					//store the element of the first array in a new array and move next
					newArray[k] = firstArray[i++];
				}
			} else {
				//all the same as for first array
				if (j == secondArray.length - 1) {
					newArray[k++] = secondArray[j++];
					break;
				} else {
					newArray[k] = secondArray[j++];

				}
			}
		}

		//if we reached the end of second array in the previous cycle
		while (i < firstArray.length) {
			//add all remaining elements from the first array to the new one
			newArray[k++] = firstArray[i++];
		}

		while (j < secondArray.length) {
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

			if (value >= 0) {
				break;
			} else {
				System.out.println("The N must be greater than zero! Enter again: ");
			}
		}

		return value;
	}
}
