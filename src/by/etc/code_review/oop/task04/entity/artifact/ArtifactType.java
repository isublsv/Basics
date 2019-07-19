package by.etc.code_review.oop.task04.entity.artifact;

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
