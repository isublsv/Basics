package by.etc.code_review.simple_obj.task03;

/**
 * 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив из пяти
 * элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров групп
 * студентов, имеющих оценки, равные только 9 или 10.
 */

public class Task {

	public static void main(String[] args) {

		Student[] students = {
				new Student("Popov N. A.", 103913),
				new Student("Sidorov R. O.", 103922),
				new Student("Petrov O. P.", 103913),
				new Student("Orlov I. A.", 103922),
				new Student("Kotova M. A.", 103920),
				new Student("Filimonova I. S.", 103922),
				new Student("Petrenko D. P.", 103913),
				new Student("Zlotova A. P.", 103920),
				new Student("Smak S. O.", 103922),
				new Student("Novikova V. M.", 103920),
		};

		for (Student student : students) {
			student.fillProgress();
		}

		System.out.println("Best of the best:");
		getBest(students);
	}

	private static void getBest(Student[] students) {
		for (Student student : students) {
			boolean b = false;
			for (int mark : student.getProgress()) {
				if (mark < 9) {
					b = false;
					break;
				} else {
					b = true;
				}
			}
			if (b) {
				System.out.println(student);
			}
		}
	}
}
