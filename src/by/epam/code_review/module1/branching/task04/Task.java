package by.epam.code_review.module1.branching.task04;

import java.util.Locale;
import java.util.Scanner;

/**
 * 4. Заданы размеры А, B прямоугольного отверстия и размеры x, y, z кирпича. Определить, пройдет ли кирпич
 * через отверстие.
 */
public class Task {
	private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {

		try {
			System.out.println("Please, enter the dimensions of the hole: ");

			double a = getValue();
			double b = getValue();
			double x = getValue();
			double y = getValue();
			double z = getValue();

			System.out.println("The brick can pass through the hole: " + isRightBrick(a, b, x, y, z));
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static boolean isRightBrick(double a, double b, double x, double y, double z) {
		if ((x <= a && y <= b) || (x <= b && y <= a)) {
			return true;
		} else if ((y <= a && z <= b) || (y <= b && z <= a)) {
			return true;
		} else return (x <= a && z <= b) || (x <= b && z <= a);
	}

	private static double getValue() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println("Enter again:");
		}
		return scanner.nextDouble();
	}
}
