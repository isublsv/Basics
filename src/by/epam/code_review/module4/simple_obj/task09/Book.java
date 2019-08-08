package by.epam.code_review.module4.simple_obj.task09;

import java.util.Arrays;

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

public class Book {

	private static int genId = 1;
	private int id;
	private String title;
	private String[] authors;
	private String publisher;
	private int year;
	private int pageNum;
	private double price;
	private String binding;

	public Book(String title, String[] authors, String publisher, int year, int pageNum, double price, String binding) {
		this.id = genId++;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.year = year;
		this.pageNum = pageNum;
		this.price = price;
		this.binding = binding;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	@Override
	public String toString() {
		return String.format("id: %d\t title: %s\t authors: %s\t publisher: %s\t year: %d\t pageNum: %d\t" +
				" price: %f\t binding: %s", id, title, Arrays.toString(authors), publisher, year, pageNum, price, binding);
	}
}
