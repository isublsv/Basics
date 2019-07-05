package by.etc.code_review.simple_obj.task05;

/**
 * 5.Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в
 * заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. Счетчик
 * имеет методы увеличения и уменьшения состояния, и метод позволяющий получить его текущее состояние. Написать код,
 * демонстрирующий все возможности класса.
 */
public class CounterRunner {

	public static void main(String[] args) {

		DecimalCounter counter = new DecimalCounter();

		System.out.println(counter);

		counter.increment();

		System.out.println(counter);

		counter.decrement();
		counter.decrement();

		System.out.println(counter);

		counter = new DecimalCounter(50, 60);

		counter.increment();
		System.out.println(counter);

		counter.decrement();

		System.out.println(counter);


	}
}
