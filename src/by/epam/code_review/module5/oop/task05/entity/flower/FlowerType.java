package by.epam.code_review.module5.oop.task05.entity.flower;

public enum FlowerType {
	ROSE("Rose"),
	TULIP("Tulip"),
	PIONY("Piony");

	private String name;

	FlowerType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
