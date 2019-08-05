package by.etc.code_review.module6.task01.utils;

import by.etc.code_review.module6.task01.entity.Content;
import by.etc.code_review.module6.task01.entity.book.Book;
import by.etc.code_review.module6.task01.entity.book.BookBuilder;
import by.etc.code_review.module6.task01.entity.book.Type;
import by.etc.code_review.module6.task01.entity.user.Email;
import by.etc.code_review.module6.task01.entity.user.Letter;
import by.etc.code_review.module6.task01.entity.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Catalog class is a singleton.
 */
public class Catalog {

	private static Catalog INSTANCE;
	private static String csvFile = "D:/WORK/Dropbox/Java/Basics/src/by/etc/code_review/module6/task01/data/catalog.csv";

	private List<Book> books;
	private List<User> users;

	private User user;
	private Email systemEmail;

	private Catalog(String username, String password) {
		this.users = UserUtils.loadUsers();
		this.user = UserUtils.login(username, password);
		this.books = loadBooks();
		this.systemEmail = new Email("catalog@mail.by");
	}


	public static Catalog getCatalog(String username, String password) {
		if (INSTANCE == null) {
			INSTANCE = new Catalog(username, password);
		}
		return INSTANCE;
	}

	/**
	 * Fills the collection by elements from a given csv file.
	 *
	 * @return the list of the books.
	 */
	private List<Book> loadBooks() {

		String line;
		String splitBy = ",";

		List<Book> books = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] data = line.split(splitBy);

				Book book = new BookBuilder().withTitle(data[0])
				                             .setPublisher(data[2])
				                             .setYear(Integer.valueOf(data[3]))
				                             .setPageNum(Integer.valueOf(data[4]))
				                             .setType(Type.valueOf(data[5].toUpperCase()))
				                             .build();

				if (data[1].contains("|")) {
					String[] authors = data[1].split("\\|");
					book.setAuthors(authors);
				} else {
					book.setAuthors(new String[]{data[1]});
				}

				books.add(book);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = UserUtils.login(user.getUsername(), new String(user.getPassword()));
	}

	/**
	 * Send email to all admin users.
	 *
	 * @param subject the subject of the email.
	 * @param content the content of the email.
	 */
	public void sendBookToCaatalog(String subject, String text, Content content) {
		for (User user : users) {
			if (UserUtils.isAdmin(user)) {
				Letter letter = new Letter(this.user.getEmail(), user.getEmail(), subject, text, content);
				this.user.getEmail().getOutbox().add(letter);
				user.getEmail().getInbox().add(letter);
			}
		}
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public boolean addSubscribers(User user){
		return UserUtils.addUser(user);
	}

	public boolean removeSubscribers(User user){
		return UserUtils.removeUser(user);
	}

	public Email getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(Email systemEmail) {
		this.systemEmail = systemEmail;
	}

	/**
	 * Appends the specified book to the end of this list.
	 *
	 * @param book element to be appended to this list
	 */
	public void addBook(Book book) {
		if (UserUtils.isAdmin(user) && !books.contains(book)) {
			books.add(book);
			saveCatalog();
			notifyObservers(Operation.ADDED, book, systemEmail);
		} else if (books.contains(book)) {
			System.out.println("The catalog contains this book!");
		} else if (!UserUtils.isAdmin(user)) {
			System.out.println("You don't have access for that operation!");
		}
	}

	/**
	 * Removes the first occurrence of the book from this list,
	 * if it is present.
	 *
	 * @param book to be removed from this list, if present
	 */
	public void removeBook(Book book) {
		if (UserUtils.isAdmin(user)) {
			books.remove(book);
			saveCatalog();
			notifyObservers(Operation.REMOVED, book, systemEmail);
		} else if (!books.contains(book)) {
			System.out.println("The catalog doesn't contain this book!");
		} else if (!UserUtils.isAdmin(user)) {
			System.out.println("You don't have access for that operation!");
		}
	}

	/**
	 * Backup all catalog in the csv file after each change operation.
	 */
	private void saveCatalog() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
			for (Book book : books) {
				StringBuilder sb = new StringBuilder();
				sb.append(book.getTitle());
				sb.append(",");

				if (book.getAuthors().length > 1) {
					Arrays.stream(book.getAuthors()).forEach(s -> sb.append(s).append("|"));
					sb.deleteCharAt(sb.length() - 1);
				} else {
					sb.append(book.getAuthors()[0]);
				}

				sb.append(",");
				sb.append(book.getPublisher());
				sb.append(",");
				sb.append(book.getYear());
				sb.append(",");
				sb.append(book.getPageNum());
				sb.append(",");
				sb.append(book.getType().name().toLowerCase());

				bw.write(sb.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the list of books by author or the empty list if there are no such books.
	 *
	 * @param author the author of the book
	 * @return the list of books by author
	 */
	public List<Book> findBooksByAuthor(String author) {
		List<Book> booksByAuthors = new ArrayList<>();

		books.forEach(book -> Arrays.stream(book.getAuthors())
		                            .filter(str -> str.equalsIgnoreCase(author))
		                            .map(str -> book)
		                            .forEach(booksByAuthors::add));

		return booksByAuthors;
	}

	/**
	 * Returns the list of books by title or the empty list if there are no such books.
	 *
	 * @param title the title of the book
	 * @return the list of books by title
	 */
	public List<Book> findBooksByTitle(String title) {

		return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
	}

	private void notifyObservers(Operation operation, Book book, Email systemEmail) {
		for (User user : users) {
			if (!UserUtils.isAdmin(user)) {
				user.update(operation, book, systemEmail);
			}
		}
	}
}
