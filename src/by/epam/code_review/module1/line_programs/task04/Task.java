package by.epam.code_review.module1.line_programs.task04;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * 4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой части). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter a number in format \"nnn.ddd\": ");

			double number = getValue();

			System.out.println(calculateExpression(number));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double calculateExpression(double number) {
		double mod = abs(number);           //get the absolute value of the number
		int integerPart = (int) mod;            //get integer part of the number (nnn)
		int decimalPart = (int) round(((mod - integerPart) * 1000));            //get decimal part of the number (ddd)
		return decimalPart + integerPart / 1000d;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
