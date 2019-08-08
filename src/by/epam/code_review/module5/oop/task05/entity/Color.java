package by.epam.code_review.module5.oop.task05.entity;

public enum Color {
	RED("Red"),
	YELLOW("Yellow"),
	BLUE("Blue"),
	WHITE("White"),
	PURPLE("Purple"),
	ORANGE("Orange"),
	GOLDEN("Golden"),
	CORAL("Coral"),
	CYAN("Cyan"),
	PINK("Pink");

	private String name;

	Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
