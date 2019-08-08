package by.epam.code_review.module4.agr_comp.task03.entity;

public class City {

	private String name;
	private long population;
	private double square;

	public City(String name, long population, double square) {
		this.name = name;
		this.population = population;
		this.square = square;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public double getSquare() {
		return square;
	}

	@Override
	public String toString() {
		return name;
	}
}
