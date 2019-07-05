package by.etc.code_review.simple_obj.task09;

/**
 * 9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
 * toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. Задать
 * критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(авторы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * а) список кинг заданного автора;
 * б) список книг, выпущенных заданным издательствомж
 * в) список кинг, выпущенных после заданного года.
 */

public class BookStore {

	private String name;
	private Book[] books;

	public BookStore(String name, Book[] books) {
		this.name = name;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public void getBooksByAuthor(String author){

		boolean haveAuthor = false;

		for (Book book : books){
			for (String str : book.getAuthors()){
				if (str.equalsIgnoreCase(author)){
					System.out.println(book);
					haveAuthor = true;
				}
			}
		}

		if (!haveAuthor){
			System.out.println("There are no books of the author in the book store!");
		}

	}

	public void getBooksByPublisher(String publisher){

		boolean havePub = false;

		for (Book book : books){
			if (book.getPublisher().equalsIgnoreCase(publisher)){
				System.out.println(book);
				havePub = true;
			}
		}

		if (!havePub){
			System.out.println("There are no books of the publisher in the book store!");
		}

	}

	public void getBooksAfterYear(int year){

		boolean afterYear = false;

		for (Book book : books){
			if (book.getYear() > year){
				System.out.println(book);
				afterYear = true;
			}
		}

		if (!afterYear){
			System.out.println("There are no books after " + year + " in the book store!");
		}
	}

	@Override
	public String toString() {
		return "Book store \"" + name + "\"";
	}
}
