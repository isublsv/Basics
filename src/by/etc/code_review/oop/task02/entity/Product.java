package by.etc.code_review.oop.task02.entity;

public class Product {

	private static int genId = 1;
	private int id;
	private String name;
	private String description;
	private double price;

	public Product(String name, String description, double price) {
		this.id = genId++;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product: #%d\t %s\t, %s\t, %.2f", id, name, description, price);
	}
}
