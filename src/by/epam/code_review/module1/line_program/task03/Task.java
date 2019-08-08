package by.epam.code_review.module1.line_program.task03;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 * (sin x + cos y)/ (cos x - sin y) * tg xy.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter x and y in degrees:");

			double x = getValue();
			double y = getValue();

			double rad = 0.01745d;
			System.out.println(calculateExpression(x * rad, y * rad));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static double calculateExpression(double x, double y) {
		return (sin(x) + cos(y)) / (cos(x) - sin(y)) * tan(x * y);
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
