package by.epam.code_review.module1.cycle.task04;

import java.math.BigInteger;

/**
 * 4. Составить программу нахождения произведения квадратов первых двухсот чисел
 */
public class Task {

	public static void main(String[] args) {

		int itr = 200;
		BigInteger multiply = new BigInteger("1");

		for (int i = 1; i <= itr; i++) {
			multiply = multiply.multiply(BigInteger.valueOf(i * i));
		}

		System.out.println(multiply);
	}
}
