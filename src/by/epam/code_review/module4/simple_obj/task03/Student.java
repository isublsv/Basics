package by.epam.code_review.module4.simple_obj.task03;

import java.util.Random;

/**
 * 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти
 * элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров групп
 * студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student {

	private String name;
	private int groupId;
	private int[] progress;

	public Student(String name, int groupId) {
		this.name = name;
		this.groupId = groupId;
		this.progress = new int[5];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int[] getProgress() {
		return progress;
	}

	public void setProgress(int[] progress) {
		this.progress = progress;
	}

	public void fillProgress(){
		for (int i = 0; i < progress.length; i++) {
			progress[i] = new Random().nextInt(3) + 8;
		}
	}

	@Override
	public String toString() {
		return "name='" + name + "', groupId=" + groupId;
	}
}
