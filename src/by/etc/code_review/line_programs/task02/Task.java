package by.etc.code_review.line_programs.task02;

import static java.lang.Math.*;

/**
 * Class description goes here.
 */
public class Task {

	public static void main(String[] args) {
		System.out.println(calculateNumber(10, 20, 30));
		System.out.println(calculateNumber(0, 20, 30));
	}

	public static double calculateNumber(long a, long b, long c) {
		double sqrt = sqrt(pow(b, 2) + 4 * a * c);
		return (b + sqrt) / 2 * a - pow(a, 3) * c + pow(b, -2);
	}
}
