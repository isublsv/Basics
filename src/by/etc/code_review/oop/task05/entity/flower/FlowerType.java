package by.etc.code_review.oop.task05.entity.flower;

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
