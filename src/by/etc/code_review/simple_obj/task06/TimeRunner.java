package by.etc.code_review.simple_obj.task06;

/**
 6. Составьте описание класса для представления времени. Предусмотрите возможности установки времени и изменения его
 * отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений
 * полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и
 * секунд.
 */

public class TimeRunner {

	public static void main(String[] args) {

		Time time = new Time();

		time.setHours(24);
		time.setMinutes(60);
		time.setSeconds(60);

		System.out.println(time);

		time = new Time(25, 59, 70);

		System.out.println(time);

		time.addHours(31);

		System.out.println(time);

		time.addMinutes(20);

		System.out.println(time);

		time.addSeconds(3700);

		System.out.println(time);

/*      Output:
				Current time is 0 hours, 0 minutes, 0 seconds.
				Current time is 0 hours, 59 minutes, 0 seconds.
				Current time is 7 hours, 59 minutes, 0 seconds.
				Current time is 8 hours, 19 minutes, 0 seconds.
				Current time is 10 hours, 20 minutes, 40 seconds.
				Current time is 10 hours, 20 minutes, 0 seconds.*/
	}
}
