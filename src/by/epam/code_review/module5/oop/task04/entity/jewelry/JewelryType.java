package by.epam.code_review.module5.oop.task04.entity.jewelry;

public enum JewelryType {
	AMULET("Amulet"),
	BELT("Belt"),
	RING("Ring"),
	QUIVER("Quiver"),
	EARRINGS("Earrings");

	private String name;

	JewelryType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
