package by.epam.code_review.module2.array_sort.task07;

import java.util.Random;
import java.util.Scanner;

/**
 * 7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
 * Требуется указать места, на которые нужно вставлять элементы последовательности b1 <= b2 <= ... <= bm в первую
 * последовательность так, чтобы новая последовательностьоставалось возрастающией.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension A:");
			int a = checkArrayDimension();

			System.out.println("Please, enter dimension B:");
			int b = checkArrayDimension();

			double[] arrA = fillArrayInAscendingOrder(a);

			System.out.println("Array A:");
			printArray(arrA);

			double[] arrB = fillArrayInAscendingOrder(b);

			System.out.println("Array B:");
			printArray(arrB);

			System.out.println("Element's indexes of the array B in the new array: ");
			getIndexes(arrA, arrB);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static void getIndexes(double[] arrA, double[] arrB) {

		double[] newArray = new double[arrA.length + arrB.length];

		int i = 0;      //index in first array
		int j = 0;      //index in second array

		int k;          //index in new array

		//var for print indexes
		int index;

		for (k = 0; k < newArray.length; k++) {
			//compare elements of both arrays
			if (arrA[i] < arrB[j]) {
				//if index is the last element of first array
				if (i == arrA.length - 1) {

					//store the element of the first array in a new array and move to next indexes newArr and A
					newArray[k++] = arrA[i++];

					//exit from the cycle
					break;
				} else {
					//store the element of the first array in a new array and move to next index of A
					newArray[k] = arrA[i++];
				}
			} else {
				//all the same as for first array
				if (j == arrB.length - 1) {

					//save current index for print
					index = k;

					//store the element of the second array in a new array and move to next indexes newArr and B
					newArray[k++] = arrB[j++];

					//print index of the element of the array B in the new array
					System.out.print(index + " ");

					//exit from the cycle
					break;
				} else {
					//save current index for print
					index = k;

					//store the element of the second array in a new array and move to next index of B
					newArray[k] = arrB[j++];

					//print index of the element of the array B in the new array
					System.out.print(index + " ");
				}
			}
		}

		//add all rest of elements from the array B to the new Array
		while (j < arrB.length) {
			index = k;

			newArray[k++] = arrB[j++];

			System.out.print(index + " ");
		}
	}

	private static double[] fillArrayInAscendingOrder(int n) {

		double[] array = new double[n];
		Random r = new Random();

		double lastValue = 0;

		for (int i = 0; i < array.length; i++) {
			double currentValue = r.nextDouble() * 200 + 100;
			lastValue = lastValue + currentValue;
			array[i] = lastValue;
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
