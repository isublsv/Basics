package by.etc.code_review.decomposition.task07;

/**
 * 7. Написать метод (методы) для вычисления суммы факториалов все нечетных чисел от 1 до 9.
 */
public class Task {

	public static void main(String[] args) {

		int sum = sumFactorials();
		System.out.println("Sum of factorials of odd numbers = " + sum);
	}

	private static int sumFactorials() {

		int sum = 0;

		for (int i = 1; i < 10; i++) {
			if (i % 2 != 0) {
				sum += getFactorial(i);
			}
		}
		return sum;
	}

	private static int getFactorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * getFactorial(n - 1);
	}
}
