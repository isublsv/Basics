package by.etc.code_review.cycles.task03;

/**
 * 3. Найти сумму квадратов первых ста чисел.
 */
public class Task {

	public static void main(String[] args) {

		int itr = 100;
		long sum = 0;

		for (int i = 1; i <= itr; i++) {
			sum += (i * i);
		}

		System.out.println(sum);        //338350
	}
}
