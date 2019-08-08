package by.epam.code_review.module5.oop.task04.entity.artifact;

public enum ArtifactType {
	BOOK("Book"),
	SCROLL("Scroll"),
	POTION("Potion"),
	RUNE("Rune"),
	KEY("Key");

	private String name;

	ArtifactType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
