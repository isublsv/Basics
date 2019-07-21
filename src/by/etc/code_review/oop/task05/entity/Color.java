package by.etc.code_review.oop.task05.entity;

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