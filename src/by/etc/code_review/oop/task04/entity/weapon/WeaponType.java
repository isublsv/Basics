package by.etc.code_review.oop.task04.entity.weapon;

public enum WeaponType {
	AXE("Axe"),
	MACE("Mace"),
	SWORD("Sword"),
	BOW("Bow"),
	CLAW("Claw"),
	DAGGER("Dagger"),
	STAFF("Staff"),
	WAND("Wand");

	private String name;

	WeaponType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
