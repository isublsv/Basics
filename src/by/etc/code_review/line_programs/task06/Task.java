package by.etc.code_review.line_programs.task06;

import java.util.Locale;
import java.util.Scanner;

/**
 * 6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (x, y)
 * принадлежит закрашенной области, и false - в противном случае.
 */
public class Task {

	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter numbers x and y: ");

			double x = getValue();
			double y = getValue();

			System.out.println(isInTheArea(x, y));
		} finally {
			if (scanner != null){
				scanner.close();
			}
		}
	}

	private static boolean isInTheArea(double x, double y) {
		if (x >= -2 && x <= 2 && y <= 0 && y >= -1.5) {
			return true;
		} else return x >= -1 && x <= 1 && y >= 0 && y <= 2;
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
