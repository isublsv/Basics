package by.epam.code_review.module5.oop.task04.entity.armor;

/**
 * Class description goes here.
 */
public enum ArmorType {
	CHEST_PLATE("Chest plate"),
	BOOTS("Boots"),
	GLOVES("Gloves"),
	HELMET("Helmet"),
	SHIELD("Shield");

	private String name;

	ArmorType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
