package by.etc.code_review.line_programs.task01;


/**
 * 1. Найдите значение функции: z = ((a - 3) * b / 2) + c.
 */
public class Task {

	public static void main(String[] args) {
		System.out.println(calculateNumber(10, 20, 30));
	}

	public static long calculateNumber(long a, long b, long c) {
		return ((a - 3) * b / 2) + c;
	}
}
