package by.etc.code_review.module6.task01;

import by.etc.code_review.module6.task01.entity.book.Book;
import by.etc.code_review.module6.task01.entity.book.BookBuilder;
import by.etc.code_review.module6.task01.entity.book.Type;
import by.etc.code_review.module6.task01.entity.user.User;
import by.etc.code_review.module6.task01.utils.Catalog;

/**
 * 1. Создать консольное приложение "Учет книг в домашней библиотеке".
 * Общие требования к заданию:
 * а) Система учитывает книги как в электронном, так и в бумажном варианте.
 * б) Существующие роли: пользователь, администратор.
 * в) Пользователь может просматривать книги в каталоге книг, осушествлять поиск книг в каталоге.
 * г) Администатор может модифицировать каталог.
 * д) *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям.
 * е) **При просмотре каталога желательно реализовать постраничный просмотр.
 * ж) ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.
 * з) Каталог книг хранится в текстовом файле.
 * к) Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде.
 */

public class Task {

	public static void main(String[] args) {

		Catalog catalog = Catalog.getCatalog("baba_yaga", "admin");

		catalog.printBooks(catalog.getBooks());
		catalog.nextPage(catalog.getBooks());

		Book book = new BookBuilder().withTitle("Java")
		                             .withAuthors(new String[]{"Bloch"})
		                             .setPublisher("Ascona")
		                             .setYear(2010)
		                             .setPageNum(750)
		                             .setType(Type.AUDIO)
		                             .build();

		catalog.addBook(book);
		catalog.removeBook(book);

		User user = new User("seeker", "seeker");

		catalog.setUser(user);

		System.out.println("=================================");
		catalog.printBooks(catalog.getBooks());
		catalog.nextPage(catalog.getBooks());

		catalog.removeBook(book);

		System.out.println("=================================");
		catalog.printBooks(catalog.getBooks());
		catalog.nextPage(catalog.getBooks());
		catalog.previousPage(catalog.getBooks());

		System.out.println("=================================");
		catalog.printBooks(catalog.findBooksByAuthor("Lewis Carroll"));

		System.out.println("=================================");

		Book book2 = new BookBuilder().withTitle("C++")
		                            .withAuthors(new String[]{"NotBloch"})
		                            .setPublisher("North Star")
		                            .setYear(2001)
		                            .setPageNum(820)
		                            .setType(Type.PAPER)
		                            .build();

		catalog.addBook(book2);

		catalog.getUser().getEmail().printInbox();
	}
}
