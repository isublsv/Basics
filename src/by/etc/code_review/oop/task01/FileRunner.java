package by.etc.code_review.oop.task01;

import by.etc.code_review.oop.task01.entity.Directory;
import by.etc.code_review.oop.task01.entity.File;
import by.etc.code_review.oop.task01.entity.TextFile;

/**
 * 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать, вывести
 * на консоль содержимое, дополнить, удалить.
 */

public class FileRunner {

	public static void main(String[] args) {

		Directory directory = new Directory("Books");

		File book1 = new TextFile("Play to live.");
		File book2 = new TextFile("Learning Java.");
		File book3 = new TextFile("Algorithms.");
		File book4 = new TextFile("Learning SQL.");
		File book5 = new TextFile("Hobbit.");

		directory.addFile(book1);
		directory.addFile(book2);
		directory.addFile(book3);
		directory.addFile(book4);
		directory.addFile(book5);

		directory.printFiles();

		System.out.println(book1.getCreated());

		book1.read();
		System.out.println(book1.getOpened());

		book1.printContent();

		book1.addContent("Hello");
		System.out.println(book1.getModified());

		book1.getSize();

		book1.printContent();



	}
}
