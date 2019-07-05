package by.etc.code_review.simple_obj.task05;

import java.util.Random;

/**
 * 5.Опищите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в
 * заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. Счетчик
 * имеет методы увеличения и уменьшения состояния, и метод позволяющий получить его текущее состояние. Написать код,
 * демонстрирующий все возможности класса.
 */

public class DecimalCounter {

	private int counter;
	private int min;
	private int max;

	public DecimalCounter() {
		this.counter = 0;
		this.min = 0;
		this.max = 100;
	}

	public DecimalCounter(int min, int max) {
		this.min = min;
		this.max = max;
		Random random = new Random();
		this.counter = random.nextInt((max - min) + 1) + min;
	}

	public int getCounter() {
		return counter;
	}

	public void increment() {
		counter++;
		if (counter > max) {
			counter = min;
		}
	}

	public void decrement() {
		counter--;
		if (counter < min) {
			counter = max;
		}
	}

	@Override
	public String toString() {
		return "counter = " + counter;
	}
}
