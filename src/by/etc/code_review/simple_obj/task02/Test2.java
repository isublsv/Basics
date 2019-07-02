package by.etc.code_review.simple_obj.task02;

/**
 * 2. Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами. Добавьте конструктор,
 * инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей класса.
 */

public class Test2 {

	private int id;
	private int value;

	public Test2() {
		this.id = 1;
		this.value = 100;
	}

	public Test2(int id, int value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
