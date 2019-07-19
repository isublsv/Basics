package by.etc.code_review.array_sort.task08;

import java.util.Random;
import java.util.Scanner;

/**
 * 8. Даны дроби p1 / q1, p2 / q2, ..., pn / qn (pi, qi - натуральные). Составьте программу, которая приводит эти дроби
 * к общему знаменателяю и упорядочивает их в порядке возрастания.
 */

public class Task {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter dimension N of the P and Q arrays:");
			int n = checkArrayDimension();

			int[] numerators = fillArray(n);
			int[] denominators = fillArray(n);

			System.out.println("The given fractions: ");
			printFractions(numerators, denominators);

			int nok = getNokOfArray(denominators);
			//System.out.println("The Least Common Multiple = " + nok);

			int[] arr = getFinalArrayOfNumerators(numerators, denominators, nok);

			sortArrOfNumerators(arr);

			System.out.println("The sorted final array of the fractions:");
			printFinalFractions(arr, nok);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	//shell sort
	private static void sortArrOfNumerators(int[] arr) {
		int in, out;
		int temp;
		int h = 1;

		//found initial step value
		while (h <= arr.length) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (out = h; out < arr.length; out++) {
				temp = arr[out];
				in = out;
				while (in > h - 1 && arr[in - h] >= temp) {
					arr[in] = arr[in - h];
					in -= h;
				}
				arr[in] = temp;
			}
			h = (h - 1) / 3;    //decrease h
		}
	}

	private static int[] getFinalArrayOfNumerators(int[] numerators, int[] denominators, int nok) {

		int[] result = new int[numerators.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = numerators[i] * (nok / denominators[i]);
		}
		return result;
	}

	private static int getNokOfArray(int[] denominators) {

		int result = denominators[0];
		for (int elem : denominators) {
			result = getNok(result, elem);

		}
		return result;
	}

	private static int getNok(int a, int b) {
		return a * (b / getNOD(a, b));
	}

	private static int getNOD(int a, int b) {

		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		return a;
	}

	private static int[] fillArray(int n) {

		int[] array = new int[n];
		Random r = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(20) + 1;
		}

		return array;
	}

	private static void printFractions(int[] numerators, int[] denominators) {

		for (int i = 0; i < numerators.length; i++) {
			System.out.println(numerators[i] + "\t/\t" + denominators[i]);
		}
	}


	private static void printFinalFractions(int[] arr, int nok) {

		for (int value : arr) {
			System.out.println(value + "\t/\t" + nok);
		}
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

			if (value > 0) {
				break;
			} else {
				System.out.println("The N must be greater than zero! Enter again: ");
			}
		}

		return value;
	}
}
