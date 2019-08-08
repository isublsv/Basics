package by.epam.code_review.module5.oop.task05.entity.wrap;

public enum WrapType {
	PAPER("Paper"),
	CLOTH("Cloth"),
	RIBBON("Ribbon"),
	MEMBRANE("Membrane");

	private String name;

	WrapType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
