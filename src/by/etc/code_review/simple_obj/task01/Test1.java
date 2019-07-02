package by.etc.code_review.simple_obj.task01;

/**
 * 1. Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы для изменения этих переменных.
 * Добавьте метод, который находит сумму значений этих переменных, и метод, который находит наибольшее значение из
 * этих двух переменных.
 */

public class Test1 {

	private int a;
	private int b;

	public int getSum() {
		return a + b;
	}

	public int getMaxValue() {
		return a > b ? a : b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "a=" + a + ", b=" + b;
	}
}
