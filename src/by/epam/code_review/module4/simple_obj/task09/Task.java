package by.epam.code_review.module4.simple_obj.task09;

public class Task {

	public static void main(String[] args) {

		Book[] books = {
				new Book("Alice's Adventures in Wonderland", new String[]{"Lewis Carroll"}, "Gascon",
						1865, 265, 50.99, "Hardcover"),
				new Book("Warriors Box Set", new String[]{"Erin Hunter"}, "Forest",
						2006, 330, 15.99, "Sewn"),
				new Book("The Colour of Magic", new String[]{"Terry Pratchett"}, "Gascon",
						1983, 228, 18.99, "Sewn"),
				new Book("A Spell for Chameleon", new String[]{"Piers Anthony"}, "WorldCat",
						1977, 425, 34.99, "Hardcover"),
				new Book("Sabriel", new String[]{"Garth Nix"}, "WorldCat",
						1995, 260, 44.99, "Hardcover"),
				new Book("Sylvie and Bruno", new String[]{"Lewis Carroll"}, "Gascon",
						1865, 310, 12.99, "Sewn"),
				new Book("Fire Sea", new String[]{"Margaret Weiss", "Brian Jacques"}, "Forest",
						1991, 350, 44.99, "Hardcover"),
				new Book("Dogsbody", new String[]{"Diana Wynne Jones"}, "WorldCat",
						1865, 280, 14.99, "Sewn"),

		};

		BookStore bookStore = new BookStore("OZ", books);

		bookStore.getBooksByAuthor("Lewis Carroll");

		System.out.println();

		bookStore.getBooksByPublisher("WorldCat");

		System.out.println();

		bookStore.getBooksAfterYear(1950);
	}
}
