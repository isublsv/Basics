package by.epam.code_review.module4.agr_comp.task05.entity;

public class Client {

	private static int genId = 1;
	private int id;
	private String name;
	private String lastname;

	public Client(String name, String lastname) {
		this.id = genId++;
		this.name = name;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String toString() {
		return String.format("#%d\t %s, %s\t", id, lastname, name);
	}
}
